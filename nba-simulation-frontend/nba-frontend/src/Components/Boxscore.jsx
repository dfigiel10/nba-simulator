import React from "react";
import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

const API_URL = import.meta.env.API_URL || 'http://localhost:8080';

export default function Boxscore( {gameId} ) {
    const [boxscore, setBoxscore] = useState([]);

    const fetchBoxscore = async (gameId) => {
        const res = await axios(`${API_URL}/api`)
        // const res = await axios(`http://localhost:8080/api`)
    }
}