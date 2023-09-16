import svelte from 'rollup-plugin-svelte';
import resolve from '@rollup/plugin-node-resolve';
import pkg from './package.json';

const name = pkg.name
    .replace(/^(@\S+\/)?(svelte-)?(\S+)/, '$3')
    .replace(/^\w/, m => m.toUpperCase())
    .replace(/-\w/g, m => m[1].toUpperCase());

export default {
    input: 'src/web_components.js',
    output: [
        {file: pkg.module, 'format': 'es'},
        {file: pkg.main, 'format': 'umd', name}
    ],
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
