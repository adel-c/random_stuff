*Psst — looking for a more complete solution? Check out [SvelteKit](https://kit.svelte.dev) and its [package command](https://kit.svelte.dev/docs/packaging) which gives you more built-in features like TypeScript transpilation, type definition generation and a built-in playground to test your library.*

*Looking for an app template instead? Go here --> [sveltejs/template](https://github.com/sveltejs/template)*

---

# component-template

A base for building shareable Svelte components. Clone it with [degit](https://github.com/Rich-Harris/degit):

```bash
npx degit sveltejs/component-template my-new-component
cd my-new-component
npm install # or yarn
```

Your component's source code lives in `src/Component.svelte`.

You can create a package that exports multiple components by adding them to the `src` directory and editing `src/web_components.js` to reexport them as named exports.

TODO

* [ ] some firm opinions about the best way to test components
* [ ] update `degit` so that it automates some of the setup work


## Setting up

* Run `npm init` (or `yarn init`)
* Replace this README with your own


## Consuming components

Your package.json has a `"svelte"` field pointing to `src/web_components.js`, which allows Svelte apps to import the source code directly, if they are using a bundler plugin like [rollup-plugin-svelte](https://github.com/sveltejs/rollup-plugin-svelte) or [svelte-loader](https://github.com/sveltejs/svelte-loader) (where [`resolve.mainFields`](https://webpack.js.org/configuration/resolve/#resolve-mainfields) in your webpack config includes `"svelte"`). **This is recommended.**

For everyone else, `npm run build` will bundle your component's source code into a plain JavaScript module (`dist/index.mjs`) and a UMD script (`dist/web_components.js`). This will happen automatically when you publish your component to npm, courtesy of the `prepublishOnly` hook in package.json.
