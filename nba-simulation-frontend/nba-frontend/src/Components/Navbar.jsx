import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
    return (
        <>
            <nav className = "fixed top-0 left-0 w-full bg-gray-900 text-white p-4 shadow-md z-50">
                <div className = "container mx-auto flex items-center justify-between">
                    <div className = "text-xl font-bold tracking-wide">
                        NBA Simulator
                    </div>
                    <div className = "space-x-6">
                        <Link to="/" className = "hover:text-yellow-400 transition">Home</Link>
                        <Link to = "/teams" className = "hover:text-yellow-400 transition">Teams</Link>
                        <Link to = "/players" className = "hover:text-yellow-400 transition">Players</Link>
                        <Link to = "/schedule" className = "hover:text-yellow-400 transition">Schedule</Link>
                    </div>
                </div>
            </nav>
        </>
    );
}