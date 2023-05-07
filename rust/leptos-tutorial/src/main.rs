use leptos::*;

fn main() {
    mount_to_body(|cx| view! { cx, <App/> })
}

#[component]
fn App(cx: Scope) -> impl IntoView {
    let (count, set_count) = create_signal(cx, 0);
    let double_count = move || count() * 2;
    let triple_count = move || count() * 3;
    view! { cx,
        <button
            class:red=move || count() % 2 == 1
            on:click=move |_| {
                set_count.update(|n| *n += 1);
            }
        >
            "Click me: "
            {count}
        </button>
        <ProgressBar progress=count max=100 />
        <ProgressBar progress=double_count max=100/>
        <ProgressBar progress=triple_count max=100 />
    }
}


#[component]
fn ProgressBar<F>(
    cx: Scope,
    #[prop(default = 100)]
    max: u16,
    progress:  F,
) -> impl IntoView
where F : Fn() -> i32 +'static{
    view! { cx,
        <div>
        <progress
            max=max
            // hmm... where will we get this from?
            value=progress
        />
        </div>

    }
}
