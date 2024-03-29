import { S as SvelteElement, i as init, a as attribute_to_object, b as insert, f as flush, s as safe_not_equal, e as element, n as noop, g as attr, h as append, k as detach } from './index-9968bab0.js';

/* src/Button.svelte generated by Svelte v3.59.2 */

function create_fragment(ctx) {
	let button;
	let slot;
	let button_class_value;

	return {
		c() {
			button = element("button");
			slot = element("slot");
			this.c = noop;
			attr(button, "class", button_class_value = /*type*/ ctx[0] == "solid" ? "btn-solid" : "btn-outline");
		},
		m(target, anchor) {
			insert(target, button, anchor);
			append(button, slot);
		},
		p(ctx, [dirty]) {
			if (dirty & /*type*/ 1 && button_class_value !== (button_class_value = /*type*/ ctx[0] == "solid" ? "btn-solid" : "btn-outline")) {
				attr(button, "class", button_class_value);
			}
		},
		i: noop,
		o: noop,
		d(detaching) {
			if (detaching) detach(button);
		}
	};
}

function instance($$self, $$props, $$invalidate) {
	let { type = "solid" } = $$props;

	$$self.$$set = $$props => {
		if ('type' in $$props) $$invalidate(0, type = $$props.type);
	};

	return [type];
}

class Button extends SvelteElement {
	constructor(options) {
		super();
		const style = document.createElement('style');
		style.textContent = `button{padding:10px;color:#fff;font-size:17px;border-radius:5px;border:1px solid #ccc;cursor:pointer}.btn-solid{background:#20c997;border-color:#4cae4c}.btn-outline{color:#20c997;background:transparent;border-color:#20c997}`;
		this.shadowRoot.appendChild(style);

		init(
			this,
			{
				target: this.shadowRoot,
				props: attribute_to_object(this.attributes),
				customElement: true
			},
			instance,
			create_fragment,
			safe_not_equal,
			{ type: 0 },
			null
		);

		if (options) {
			if (options.target) {
				insert(options.target, this, options.anchor);
			}

			if (options.props) {
				this.$set(options.props);
				flush();
			}
		}
	}

	static get observedAttributes() {
		return ["type"];
	}

	get type() {
		return this.$$.ctx[0];
	}

	set type(type) {
		this.$$set({ type });
		flush();
	}
}

customElements.define("cool-button", Button);

export { Button as default };
