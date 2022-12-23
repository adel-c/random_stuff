import Layout from '../../components/layout';
import React, {useEffect, useState} from "react";
import {Todo} from "../../lib/Domain";
import {SubmitHandler, useForm} from "react-hook-form";
import {fetchTodos, postTodo} from "../../lib/Todo";

export default function Todos() {
    const {register, handleSubmit, watch, formState: {errors}} = useForm<Todo>();
    const [todos, setTodos] = useState([] as Todo[])
    const onSubmit: SubmitHandler<Todo> = async data => {
        const response = await postTodo(data);
        setTodos([...todos, response])
    };

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetchTodos()
            setTodos(response);
        }

        // call the function
        fetchData()
            // make sure to catch any error
            .catch(console.error);
    }, []);

    return (
        <Layout home>
            <h1>todos</h1>
            <form onSubmit={handleSubmit(onSubmit)}>
                <label htmlFor='todo'> TODO</label>
                <input id="todo" type="text" {...register("todo", {required: true})}/>
                {errors.todo && <span>This field is required</span>}
                <br/>
                <label htmlFor='detail'> Detail</label>

                <input id="detail" type="text" {...register("detail")}/>
                <button type={"submit"}>Submit</button>
            </form>


            <ul>

                {todos.map(t => (
                    <li key={t.todo}> {t.todo} : {t.detail}</li>
                ))}
            </ul>
        </Layout>
    );
}
