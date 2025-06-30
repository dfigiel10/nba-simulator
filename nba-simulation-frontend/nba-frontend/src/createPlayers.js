import axios from "axios";

const players = [
    {firstName: "Luka", lastName: "Doncic", height: 78, weight: 230 },
    {firstName: "Lebron", lastName: "James", height: 80, weight: 250},
    {firstName: "Austin", lastName: "Reaves", height: 79, weight: 200},
    {firstName: "Rui", lastName: "Hachimura", height: 80, weight: 230},
    {firstName: "Jackson", lastName: "Hayes", height: 84, weight: 220},

    {firstName: "Anthony", lastName: "Edwards", height: 76, weight: 225},
    {firstName: "Julius", lastName: "Randle", height: 81, weight: 249},
    {firstName: "Rudy", lastName: "Gobert", height: 85, weight: 258},
    {firstName: "Donte", lastName: "DiVincenzo", height: 76, weight: 203},
    {firstName: "Mike", lastName: "Conley", height: 72, weight: 175},

    {firstName: "Cade", lastName: "Cunningham", height: 78, weight: 220},
    {firstName: "Malik", lastName: "Beasley", height: 76, weight: 187},
    {firstName: "Tim", lastName: "Hardaway", height: 77, weight: 205},
    {firstName: "Tobias", lastName: "Harris", height: 80, weight: 226},
    {firstName: "Jalen", lastName: "Duren", height: 82, weight: 250},

    {firstName: "Jalen", lastName: "Brunson", height: 74, weight: 190},
    {firstName: "Karl", lastName: "Anthony-Towns", height: 84, weight: 248},
    {firstName: "OG", lastName: "Anunoby", height: 79, weight: 240},
    {firstName: "Mikhail", lastName: "Bridges", height: 78, weight: 209},
    {firstName: "Mitchell", lastName: "Robinson", height: 84, weight: 240},

    {firstName: "Jayson", lastName: "Tatum", height: 80, weight: 209},
    {firstName: "Jaylen", lastName: "Brown", height: 78, weight: 220},
    {firstName: "Kristaps", lastName: "Porzingis", height: 86, weight: 240},
    {firstName: "Derrick", lastName: "White", height: 76, weight: 190},
    {firstName: "Al", lastName: "Horford", height: 81, weight: 240},

    {firstName: "Dononvan", lastName: "Mitchell", height: 75, weight: 215},
    {firstName: "Darius", lastName: "Garland", height: 73, weight: 192},
    {firstName: "Ty", lastName: "Jerome", height: 77, weight: 195},
    {firstName: "Jarrett", lastName: "Allen", height: 81, weight: 243},
    {firstName: "Evan", lastName: "Mobley", height: 83, weight: 215},

    {firstName: "Nikola", lastName: "Jokic", height: 83, weight: 284},
    {firstName: "Aaron", lastName: "Gordon", height: 80, weight: 235},
    {firstName: "Michael", lastName: "Porter Jr", height: 82, weight: 218},
    {firstName: "Russell", lastName: "Westbrook", height: 76, weight: 200},
    {firstName: "Christian", lastName: "Braun", height: 78, weight: 220},

    {firstName: "James", lastName: "Harden", height: 77, weight: 220},
    {firstName: "Kawhi", lastName: "Leonard", height: 79, weight: 225},
    {firstName: "Norm", lastName: "Powell", height: 76, weight: 215},
    {firstName: "Kris", lastName: "Dunn", height: 75, weight: 205},
    {firstName: "Derrick", lastName: "Jones Jr", height: 78, weight: 210},

]

const createPlayers = async () => {
    for (const player of players) {
        try {
            const res = await axios.post("http://localhost:8080/api/player", player);
            console.log(`Created player ${player.firstName} ${player.lastName}`);
        } catch (error) {
            console.log("Error creating player")
        }
    }
}

createPlayers();