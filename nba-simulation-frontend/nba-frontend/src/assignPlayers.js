import axios from "axios";

const playerTeam = [
    // lakers
    {playerId: 9, teamId: 3}, 
    {playerId: 10, teamId: 3}, 
    {playerId: 11, teamId: 3}, 
    {playerId: 12, teamId: 3}, 
    {playerId: 13, teamId: 3},
    // timberwolves
    {playerId: 14, teamId: 4}, 
    {playerId: 15, teamId: 4}, 
    {playerId: 16, teamId: 4}, 
    {playerId: 17, teamId: 4}, 
    {playerId: 18, teamId: 4}, 
    // pistons
    {playerId: 19, teamId: 5}, 
    {playerId: 20, teamId: 5}, 
    {playerId: 21, teamId: 5}, 
    {playerId: 22, teamId: 5}, 
    {playerId: 23, teamId: 5}, 
    // knicks
    {playerId: 24, teamId: 6}, 
    {playerId: 25, teamId: 6}, 
    {playerId: 26, teamId: 6}, 
    {playerId: 27, teamId: 6}, 
    {playerId: 28, teamId: 6}, 
    // celtics
    {playerId: 29, teamId: 7}, 
    {playerId: 30, teamId: 7}, 
    {playerId: 31, teamId: 7}, 
    {playerId: 32, teamId: 7}, 
    {playerId: 33, teamId: 7}, 
    // cavs
    {playerId: 34, teamId: 8}, 
    {playerId: 35, teamId: 8}, 
    {playerId: 36, teamId: 8}, 
    {playerId: 37, teamId: 8}, 
    {playerId: 38, teamId: 8}, 
    // nuggets
    {playerId: 39, teamId: 9},
    {playerId: 40, teamId: 9},
    {playerId: 41, teamId: 9},
    {playerId: 42, teamId: 9},
    {playerId: 43, teamId: 9},
    // clippers
    {playerId: 44, teamId: 10},
    {playerId: 45, teamId: 10},
    {playerId: 46, teamId: 10},
    {playerId: 47, teamId: 10},
    {playerId: 48, teamId: 10}
]



const assignPlayers = async () => {
    for (const player of playerTeam) {
        try {
            const res = await axios.post("http://localhost:8080/api/playerTeam/assignTeam", player);
            console.log(`Assigned player ${player.playerId}`);
        } catch (error) {
            console.log("Error assigning player")
        }
    }
}

assignPlayers();