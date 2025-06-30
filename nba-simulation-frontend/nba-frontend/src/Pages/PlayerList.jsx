import React from "react";
import { useState , useEffect} from "react";
import axios from "axios";
import PlayerListItem from "../Components/PlayerListItem";

const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080';

export default function PlayerList() {
    const [players, setPlayers] = useState([]);
    const [isLoading, setIsLoading] = useState(false);

    const fetchPlayers = async () => {
        try {
            const res = await axios.get(`${API_URL}/api/player/players/all`);
            const players = res.data;
            const sortedPlayers = [...players].sort((a,b) => a.firstName.localeCompare(b.firstName));
            
            setPlayers(sortedPlayers);
        } catch (error) {
         console.error("Error fetching items: ", error);
        }
    };

    useEffect( () => {
        fetchPlayers();
    }, [] );

    return (
        <div className = "pt-16 px-4">
            <h1 className = "text-2xl font-bold mb-4">List of all players</h1>
            <div className = "grid grid-cols-3">
                <div>Name</div>
                <div>Height</div>
                <div>Weight</div>
            </div>
            <ul className = "space-y-2">
                {players.map(player => (
                    <PlayerListItem key = {player.id} player = {player} />
                ))}
            </ul>
        </div>
    );
}