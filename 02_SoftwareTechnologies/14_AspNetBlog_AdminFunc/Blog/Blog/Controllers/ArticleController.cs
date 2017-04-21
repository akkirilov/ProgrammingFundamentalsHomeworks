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

        //POST: Article/Create
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
    }
}