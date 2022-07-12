import {NextApiHandler, NextApiRequest} from "next";

const handler: NextApiHandler = (req, res) => {
           res.json({title: "admin"})
}
export default handler
