import React from "react";
import { Link } from "react-router-dom";

export default function PlayerListItem({ player }) {
    function heightConverter(height) {
        const feet = Math.round(height / 12);
        const inches = Math.round(height % 12);
        return { feet, inches};
    }
    const {feet, inches} = heightConverter(player.height);
    return (
        <li className = "grid grid-cols-3 border-b w-full p-2 hover:bg-gray-50">
            <div>
                <Link to = {`/players/${player.id}`} >
                <div>{player.firstName} {player.lastName}</div>
                </Link>

            </div>
            
            <div>{feet}'{inches}</div>
            <div>{player.weight}</div>
        </li>    
    )
}