import {NextApiHandler, NextApiRequest, NextApiResponse} from "next";

const dashboardHandler: NextApiHandler =  (req, res) => {
      return res.json({result: "dashboard"})
}

export default dashboardHandler;
