package com.ace.htmxrouter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MainController {
    PageService pageService;

    @GetMapping()
    public String main(Model model, @RequestParam Map<String, String> allRequestParams
    ) {

        pageService.openPage(Page.MAIN, model, false, allRequestParams);
        model.addAttribute("fragment", "/page/main");
        return "index";
    }

    @GetMapping("page/{*pageRef}")
    public String mainPage(Model model, @PathVariable("pageRef") String pageRef,
                           @RequestParam Map<String, String> allRequestParams,
                           @RequestHeader(value = "page-fragment", required = false, defaultValue = "false") String fragmentOnlyHeader) {
        if (pageRef.startsWith("/")) {
            pageRef = pageRef.substring(1);
        }
        Page page = Page.getPageByPath(pageRef);
        if (page == null) {
            return "not_found";
        }

        boolean fragment = "true".equalsIgnoreCase(fragmentOnlyHeader);

        String fragmentUrl = pageService.openPage(page, model, fragment, allRequestParams);
        model.addAttribute("fragment", fragmentUrl);
        if (fragment) {
            return fragmentUrl;
        }

        return "index";
    }

}
