function solve(args){
    args = args.join(' ')
        .split(/\W+/)
        .filter(x => x === x.toUpperCase())
        .filter(y=> y.length > 0)
        .join(', ');

    console.log(args);
}

solve([
    'We start by HTML, CSS, JavaScript, JSON and REST.',
    'Later we touch some PHP, MySQL and SQL.',
    'Later we play with C#, EF, SQL Server and ASP.NET MVC.',
    'Finally, we touch some Java, Hibernate and Spring.MVC.'
]);