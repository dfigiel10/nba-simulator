import React from "react";
import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080';

export default function LeadingStats({ stat }) {
    const [stats, setStats] = useState([]);

    const fetchLeadingStats = async () => {
        try {
            const res = await axios.get(`${API_URL}/api/gamePlayerStats/player/leading${stat}`);
            console.log(res.data);
            setStats(res.data);
        } catch (error) {
            console.log(error);
        }
    }

    useEffect(() => {
        fetchLeadingStats()
    }, []);

    return (
        <div className="pt-16 px-4">
        <h1 className="text-xl font-bold mb-4" >{stat} Leaders</h1>
        <table className="min-w-full border-collapse border border-gray-300">
            <thead>
                <tr className="bg-gray-100">
                    <th className="border p-2">{stat}</th>
                    <th className="border p-2">Player</th>
                    <th className="border p-2">Team</th>
                </tr>
            </thead>
            <tbody>
                {stats.map((stat) => (
                    <tr key={stat.id} className="hover:bg-gray-50">
                        <td className="border p-2 text-center">{stat.avgStat}</td>
                        <td className="border p-2 text-center">{stat.firstName} {stat.lastName}</td>
                        <td className="border p-2 text-center">{stat.teamName}</td>
                    </tr>
                ))}
            </tbody>
        </table>
        </div>
    )
}