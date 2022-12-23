import Layout from '../../components/layout';
import React, {FormEvent, useEffect, useState} from "react";
import {Todo} from "../../lib/Domain";
import { useForm, SubmitHandler } from "react-hook-form";

export default function Todos() {
    const { register, handleSubmit, watch, formState: { errors } } = useForm<Todo>();
    const [todos,setTodos]=useState([] as Todo[])
    const onSubmit: SubmitHandler<Todo> = data => {
        console.log(data)
    };

    useEffect(() => {
        fetch(`https://jsonplaceholder.typicode.com/posts`)
            .then((response) => console.log(response));
    }, []);

    return (
        <Layout home>
            <h1>todos</h1>
            <form onSubmit={handleSubmit(onSubmit)}>
                <label htmlFor='todo'> TODO</label>
                <input id="todo" type="text" {...register("todo",{required:true})}/>
                {errors.todo && <span>This field is required</span>}
                <br/>
                <label htmlFor='detail'> Detail</label>

                <input id="detail" type="text" {...register("detail")}/>
                <button type={"submit"}>Submit</button>
            </form>

        </Layout>
    );
}
