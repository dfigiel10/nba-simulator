import React from "react";
import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";
import ScheduleItem from "./ScheduleItem";

const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080';

export default function Schedule() {
    const [gameIds, setGameIds] = useState([]);
    const [games, setGames] = useState([]);

    const getSchedule = async () => {
        try {     
            const res = await axios.get(`${API_URL}/api/schedule/1`);
            const gamesListIds = res.data.gamesIDs;
            setGameIds(gamesListIds);
            const gamePromises = gamesListIds.map(gameId => getGame(gameId));
            const allGames = await Promise.all(gamePromises);
            setGames(allGames);
            // console.log(games);
            console.log(allGames)
        } catch (error) {
            console.log(error);
            console.log("fuck");
        }
    }

    const getGame = async (gameId) => {
        try {
            const res = await axios.get(`${API_URL}/api/game/getGame/${gameId}`);
            return res.data;

        } catch (error) {
            console.log(error);
        }
    }

    

    useEffect(() => {
        getSchedule();
    }, []);


    return (
        <div className = "pt-16 px-4">
            <h1 className = "text-2xl font-bold mb-4">Schedule</h1>
            <div className = "grid grid-cols-6">
                <div>Home</div>
                <div>Away</div>
                <div>Home Score</div>
                <div>Away Score</div>
                <div>Boxscore</div>
            </div>
            <ul className="space-y-2">
                {games.map((game) => (
                    <ScheduleItem key = {game.id} game = {game}/>
                    // <li key={game.id}><ScheduleItem homeTeamId = {game.homeTeam} awayTeamId = {game.awayTeam} /></li>
                ))}
            </ul>
        </div>
    )
}