using Blog.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;

namespace Blog.Controllers
{
    public class ArticleController : Controller
    {
        //GET: Article/List
        public ActionResult List()
        {
            using (var db = new BlogDbContext())
            {
                var articles = db.Articles.Include(a => a.Author).ToList();
                return View(articles);
            }
        }

        //GET: Article/Details
        [Authorize]
        public ActionResult Details(int? Id)
        {
            if (Id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using(var db = new BlogDbContext())
            {
                var article = db.Articles.Where(x => x.Id == Id).Include(x => x.Author).First();

                if (article == null)
                {
                    return HttpNotFound();
                }

                return View(article);
            }

        }

        //GET: Article/Create
        [Authorize]
        public ActionResult Create()
        {
            return View();
        }

        //POST: Article/Create
        [HttpPost]
        [Authorize]
        public ActionResult Create(Article article)
        {
            if (ModelState.IsValid)
            {
                using(var db = new BlogDbContext())
                {
                    var authorId = db.Users.Where(x => x.UserName == this.User.Identity.Name).First().Id;
                    article.AuthorId = authorId;

                    db.Articles.Add(article);
                    db.SaveChanges();

                    return RedirectToAction("Index", "Home");
                }
            }

            return View(article);
        }

        //GET: Article/Delete
        [Authorize]
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using(var db = new BlogDbContext())
            {
                var article = db.Articles.Where(x => x.Id == id).Include(x => x.Author).First();

                if (article == null)
                {
                    return HttpNotFound();
                }

                if (!isUserAuthorizedToEdit(article))
                {
                    return RedirectToAction("Details", "Article", new { id = article.Id });
                }

                return View(article);
            }
        }

        //POST: Article/Delete
        [HttpPost]
        [ActionName("Delete")]
        [Authorize]
        public ActionResult DeleteAction(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles.Where(x => x.Id == id).Include(x => x.Author).First();

                if (!isUserAuthorizedToEdit(article))
                {
                    return RedirectToAction("Details", "Article", new { id = article.Id });
                }

                if (article == null)
                {
                    return HttpNotFound();
                }

                db.Articles.Remove(article);
                db.SaveChanges();

                return RedirectToAction("Index", "Home");
            }
        }

        //GET: Article/Edit

        [Authorize]
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            using (var db = new BlogDbContext())
            {
                var article = db.Articles.Where(x => x.Id == id).Include(x => x.Author).First();

                if (article == null)
                {
                    return HttpNotFound();
                }

                if (!isUserAuthorizedToEdit(article))
                {
                    return RedirectToAction("Details", "Article", new { id = article.Id });
                }
               
                return View(article);
            }
        }

        //POST: Article/Edit
        [HttpPost]
        [Authorize]
        public ActionResult Edit(Article articleEdited)
        {
            using (var db = new BlogDbContext())
            {
                if (articleEdited == null)
                {
                    return HttpNotFound();
                }

                var article = db.Articles.Where(x => x.Id == articleEdited.Id).Include(x => x.Author).First();

                if (!isUserAuthorizedToEdit(article))
                {
                    return RedirectToAction("Details", "Article", new { id = articleEdited.Id });
                }

                article.Title = articleEdited.Title;
                article.Content = articleEdited.Content;

                db.Entry(article).State = EntityState.Modified;
                db.SaveChanges();

                return RedirectToAction("Details", "Article", new { id = article.Id });
            }
        }

        public bool isUserAuthorizedToEdit (Article article)
        {
            bool isAdmin = this.User.IsInRole("Admin");
            bool isAuthor = article.isAuthor(this.User.Identity.Name);

            return (isAdmin || isAuthor);
        }
    }
}