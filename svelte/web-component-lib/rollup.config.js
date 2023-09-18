import svelte from 'rollup-plugin-svelte';
import resolve from '@rollup/plugin-node-resolve';
import pkg from './package.json';

const name = pkg.name
    .replace(/^(@\S+\/)?(svelte-)?(\S+)/, '$3')
    .replace(/^\w/, m => m.toUpperCase())
    .replace(/-\w/g, m => m[1].toUpperCase());

export default {

/*
    //inlineDynamicImports:true,
input: "src/web_components.js",//["src/Card.svelte", "./src/Button.svelte"],
    output: {
        format: "iife",
        dir: "public/build/",
    },*/
    input: ["src/Card.svelte", "./src/Button.svelte"],
    output: {

        dir: "public/build/",
    },
    plugins: [
        svelte({
                compilerOptions: {
                    dev: false,
                    customElement: true
                }
            }
        ),
        resolve()
    ]
};
