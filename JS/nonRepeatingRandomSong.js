/*
    You are given list of songs = [1,3,5,10....100] and function random which takes two arguments startIndex and endIndex and returns a random song. 
    You have to play random song from list only one time using random function. Any song should not be played more than once.
    
    int random(int startIndex, endIndex){
        returns randomNumber;
    }
    
    O(N) solution is expected.
*/

let songs = [1, 31, 5, 91, 40, 6, 17, 28, 2, 77, 100];
let currEndIndex;

function randomMusic(startIndex, endIndex) {
    if ([null, undefined].includes(currEndIndex)) currEndIndex = endIndex;

    if (currEndIndex < startIndex) {
        console.log("no more song left")
        return;
    }

    const randomIndex = Math.floor(Math.random() * (currEndIndex - startIndex + 1)) + startIndex; // getting a random index b/w start and end

    // now swapping that element with the item at the end and decreaing the endIndex, so that that element will not be picked again in later function execution
    // same algo what we use in quick sort algo
    let temp = songs[randomIndex];
    songs[randomIndex] = songs[currEndIndex];
    songs[currEndIndex] = temp;
    currEndIndex--;

    console.log("random song", temp);
}

let endIndex = songs.length - 1;
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);
randomMusic(0, endIndex);