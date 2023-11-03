package main

import (
	"echoserver/core"
)

func main() {
	//server.Run()
	core.Truc()
	println(core.Much())
	c := &core.Template{
		Templates: "aze",
		HotReload: true,
	}
	hello, err := core.Hello("azeaze")
	if err != nil {
		return
	}
	println(hello)
	hellos, err := core.Hellos([]string{"aze", "aze"})
	if err != nil {
		return
	}
	for h := range hellos {
		println(hellos[h])
	}
	println(c.Templates)
}
