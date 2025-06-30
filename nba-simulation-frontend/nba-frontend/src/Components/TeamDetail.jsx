import React from "react";
import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";
import PlayerListItem from "./PlayerListItem";
import ScheduleItem from "./ScheduleItem";
import Schedule from "./Schedule";

const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080';

export default function TeamDetail() {
    const {id} = useParams();
    const [playerIds, setPlayerIds] = useState([]);
    const [roster, setRoster] = useState([]);
    const [teamName, setTeamName] = useState("");
    
    const fetchPlayerIds = async () => {
        try {
            const res = await axios.get(`${API_URL}/api/team/${id}`);
            setTeamName(res.data.name);
            
            const playerIds = res.data.players;
            console.log(playerIds);
            setPlayerIds(playerIds);
        } catch (error) {
            console.log("Error fetching roster: ", error)
        }
    }

    const getRoster = async (playerIds) => {
        try {
            const playerPromises = playerIds.map(playerId => (
                axios.get(`${API_URL}/api/player/${playerId}`)
            ));
            const responses = await Promise.all(playerPromises);
            const players = responses.map(res => res.data);
            setRoster(players);
            console.log(players);
        } catch (error) {
            console.log("Error getting roster: ", error);
        }
    }

    useEffect(() => {
        fetchPlayerIds();
    }, []);
    
    useEffect(() => {
        getRoster(playerIds);
    }, [playerIds]);

    return (
        <div className = "pt-16 px-4">
            <h1>{teamName}</h1>
            <div className = "pt-5 px-4">
            <div className = "grid grid-cols-3">
                <div>Name</div>
                <div>Height</div>
                <div>Weight</div>
            </div>
                <ul className = "space-y-2">
                    {roster.map(player => (
                                        // <li key = {player.id}>{player.firstName} {player.lastName} Weight: {player.weight} Height: {player.height}</li>
                                        <PlayerListItem key = {player.id} player = {player} />
                                    ))}
                </ul>
            </div>
        </div>
    )
}