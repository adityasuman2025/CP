// get power of a prime no in number
function getPowerOfPrime(number, prime) {
    let c = 0;

    while (number > 1) {
        number = Math.floor(number / prime);
        c++;
    }

    return c;
}
let ans2 = getPowerOfPrime(81, 3);
// console.log("getPowerOfPrime", ans2)


// ref: https://bigfrontend.dev/problem/the-angle-between-hour-hand-and-minute-hand-of-a-clock
function angleBWHourAndMinuteHand() {
    let [hours, minutes] = time.split(":");

    minutes = Number(minutes);
    hours = Number(hours);

    if (hours >= 12) hours = hours - 12; // because a clock has hand till 12 only

    let minuteAngle = (minutes / 60) * 360; // because 60 mins equals to 360 degree
    let hourAngle = ((hours / 12) * 360) + ((minutes / 60) * 30); // because 12 hours equals to 360 degree and hour hand move a little as minute hand move
    // on full round of minute hand (360 degree) hour hand moves by 30 degree

    let angle = Math.abs(minuteAngle - hourAngle);
    angle = angle > 180 ? 360 - angle : angle; // because we have to return smallest angle

    return Math.round(angle);
}
console.log(angleBWHourAndMinuteHand('12:00')); // 0
console.log(angleBWHourAndMinuteHand('23:30')); // 165
