using Microsoft.Owin;
using Owin;
using System.Data.Entity;
using Blog.Models;
using Blog.Migrations;

[assembly: OwinStartupAttribute(typeof(Blog.Startup))]
namespace Blog
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            

            ConfigureAuth(app);
        }
    }
}
