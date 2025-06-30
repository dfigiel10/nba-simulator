import React from "react";
import { Link } from "react-router-dom";

export default function TeamListItem({ team }) {
    return (
        <li>
            <Link to = {`/team/${team.id}`}>{team.name}</Link>
            {/* {team.players} */}
        </li>
    )
}