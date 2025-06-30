import React from "react";
import { useState } from "react";
import LeadingStats from "../Components/LeadingStats";

export default function Home() {
    return (
        <div className = "pt-16 px-4">
            <h1 className = "text-2xl font-bold mb-4">Statistical leaders...</h1>
            <LeadingStats stat="PPG" />
            <LeadingStats stat="APG" />
            <LeadingStats stat="RPG" />
        </div>
    )
}