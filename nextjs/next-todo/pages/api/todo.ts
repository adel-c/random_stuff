// Next.js API route support: https://nextjs.org/docs/api-routes/introduction
import type { NextApiRequest, NextApiResponse } from 'next'
import {Todo} from "../../lib/Domain";

const todo:Array<Todo> = new Array<Todo>()

export default function handler(
  req: NextApiRequest,
  res: NextApiResponse<Todo[]>
) {
    if (req.method === 'POST') {
      const newTodo = req.body satisfies Todo
      todo.push(newTodo)
      res.status(200).json(newTodo)
      // Process a POST request
    } else {
      res.status(200).json(todo)
    }

}
