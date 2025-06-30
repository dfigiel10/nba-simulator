import React, { useEffect } from "react";
import { useState , usefEffect} from "react";
import axios from "axios";
import TeamListItem from "../Components/TeamListItem";
import { Link } from "react-router-dom";

const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080';

export default function TeamList() {
    const [teams, setTeams] = useState([]);
    const [isLoading, setIsLoading] = useState(false);

    const fetchTeams = async () => {
        try {
            const res = await axios.get(`${API_URL}/api/team/teams`);
            const teams = res.data;
            const sortedTeams = [...teams].sort((a,b) => a.name.localeCompare(b.name));
            
            setTeams(sortedTeams);
        } catch (error) {
         console.error("Error fetching items: ", error);
        }
    };

    useEffect( () => {
        fetchTeams();
    }, [] );

    return (
        <div className = "pt-16 px-4">

            <h1 className = "text-2xl font-bold mb-4">List of all teams</h1>
            <ul className = "space-y-2">
                {teams.map(team => (
                    <TeamListItem key={team.id} team={team}/>
                ))}
            </ul>
        </div>
    );
}