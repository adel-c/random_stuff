import Layout from '../../components/layout';
import React, {useEffect, useState} from "react";
import {Todo} from "../../lib/Domain";
import {SubmitHandler, useForm} from "react-hook-form";

export default function Todos() {
    const {register, handleSubmit, watch, formState: {errors}} = useForm<Todo>();
    const [todos, setTodos] = useState([] as Todo[])
    const onSubmit: SubmitHandler<Todo> = async data => {
        const response = await fetch(`/api/todo`, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify(data)
        });

    };

    useEffect(() => {
        const fetchData = async () => {
            // get the data from the api
            const response = await fetch(`/api/todo`);
            // convert the data to json
            const json = await response.json() as Todo[];

            // set state with the result
            setTodos(json);
        }

        // call the function
        fetchData()
            // make sure to catch any error
            .catch(console.error);
        ;
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

        </Layout>
    );
}
