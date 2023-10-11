package main

import (
	"echoserver/core"
	"echoserver/server"
)

func main() {
	server.Run()
	core.Truc()
	core.Much()
	c := &core.Template{
		Templates: "aze",
		HotReload: true,
	}

	print(c.Templates)
}
