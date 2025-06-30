import React from "react";
import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080';

export default function ScheduleItem ( {game} ) {

    const [homeTeam, setHomeTeam] = useState("");
    const [awayTeam, setAwayTeam] = useState("");


    const getTeams = async () => {
        try {
            const homeTeamRes = await axios.get(`${API_URL}/api/team/${game.homeTeam}`);
            const awayTeamRes = await axios.get(`${API_URL}/api/team/${game.awayTeam}`);
            // console.log(homeTeamRes.data.name);
            const homeTeamName = homeTeamRes.data.name;
            const awayTeamName = awayTeamRes.data.name;
            setHomeTeam(homeTeamName);
            setAwayTeam(awayTeamName);

        } catch (e) {
            console.log(e);
        }
    }

    const playGame = async (gameId) => {
        try {
            const res = await axios.post(`${API_URL}/api/game/${gameId}/play`);
            console.log("game played", res.data);
        } catch (error) {
            console.log(error);
        }
    }

    function getBoxscore(gameId) {
        return <Boxscore gameId={gameId} />
        
    }

    useEffect(() => {
        getTeams();
    }, []);

    return (
        <>
            <li className = "grid grid-cols-6 border-b w-full p-2 hover:bg-gray-50">
                <div>{homeTeam}</div>
                <div>{awayTeam}</div> 
                <div>{game.homeScore}</div>
                <div>{game.awayScore}</div>
                <button onClick = {() => getBoxscore(gameId)}>Boxscore</button>
                <button onClick={() => playGame(game.id)}>Play Game</button>
            </li>
            
        </>
    )
}