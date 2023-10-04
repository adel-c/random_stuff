package main

import (
	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
	"html/template"
	"io"
	"net/http"
)

type Template struct {
	templates *template.Template
	hotReload bool
}

func parseAllTemplates() *template.Template {
	return template.Must(template.ParseGlob("public/views/*.html"))
}
func (t *Template) Render(w io.Writer, name string, data interface{}, c echo.Context) error {
	//hot reload
	if t.hotReload {
		t.templates = parseAllTemplates()
	}

	return t.templates.ExecuteTemplate(w, name, data)
}
func main() {
	// Echo instance
	e := echo.New()
	t := &Template{
		templates: parseAllTemplates(),
		hotReload: true,
	}
	e.Renderer = t
	// Middleware
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())

	// Routes
	e.GET("/", hello)
	e.GET("/coucou", coucou)

	// Start server
	e.Logger.Fatal(e.Start(":1323"))
}

type data struct {
	Name string
}

func coucou(c echo.Context) error {
	return c.Render(http.StatusOK, "hello.html", data{
		Name: "xxxcsfsf!",
	})
}

// Handler
func hello(c echo.Context) error {
	return c.String(http.StatusOK, "Hello, World!")
}
