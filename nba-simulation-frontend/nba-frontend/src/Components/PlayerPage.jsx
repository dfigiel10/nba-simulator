import React from "react";
import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080';

export default function PlayerPage () {
    const {id} = useParams();
    const [playerStats, setPlayerStats] = useState([]);

    const fetchPlayerStats = async () => {
        try {
            console.log(id);
            console.log("Fetching for id:", id);
            const res = await axios.get(`${API_URL}/api/gamePlayerStats/player/${id}`)
            //const res = await axios.get(`http://localhost:8080/api/gamePlayerStats/player/${id}`);
            console.log(res);
            setPlayerStats(res.data);
            console.log("Player stats");
            console.log(playerStats);
        } catch (error) {
            console.log("Error");
        }
    }

    useEffect(() => {
        fetchPlayerStats();
    }, [id]);

    useEffect(() => {
        console.log("Player stats update", playerStats);
    }, [playerStats])   

    return (
        <div className="pt-16 px-4">
        <h1 className="text-xl font-bold mb-4" >Player Boxscore</h1>
        <table className="min-w-full border-collapse border border-gray-300">
            <thead>
                <tr className="bg-gray-100">
                    <th className="border p-2">Game ID</th>
                    <th className="border p-2">Points</th>
                    <th className="border p-2">Assists</th>
                    <th className="border p-2">Rebounds</th>
                </tr>
            </thead>
            <tbody>
                {playerStats.map((stat) => (
                    <tr key={stat.id} className="hover:bg-gray-50">
                        <td className="border p-2 text-center">{stat.gameId}</td>
                        <td className="border p-2 text-center">{stat.points}</td>
                        <td className="border p-2 text-center">{stat.assists}</td>
                        <td className="border p-2 text-center">{stat.rebounds}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div>
    )
}