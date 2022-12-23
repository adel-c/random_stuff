import Layout from '../../components/layout';
import React, {FormEvent, useState} from "react";

type TodoForm = {
    todo: string;
    detail?:string;
}
export default function Todos() {
    const [form, setValue]: [TodoForm, ((value: (((prevState: TodoForm) => TodoForm) | TodoForm)) => void)] = useState({todo: ""} as TodoForm)

    function handleChange(event: React.FormEvent<HTMLInputElement>) {
        console.log("change event", event)
        setValue({...form, [event.currentTarget.id]: event.currentTarget.value,})
    }

    function handleSubmit(event: FormEvent) {
        event.preventDefault();
        console.log("handleSubmit", event)
        console.log("handleSubmit", form)
    }

    return (
        <Layout home>
            <h1>todos</h1>
            <form onSubmit={handleSubmit}>
                <label htmlFor='todo'> TODO</label>
                <input id="todo" type="text" placeholder={"machin"} value={form.todo} onChange={handleChange}/>
                <label htmlFor='detail'> Detail</label>
                <input id="detail" type="text" placeholder={"machin"} value={form.detail} onChange={handleChange}/>
                <button type={"submit"}>Submit</button>
            </form>
        </Layout>
    );
}
