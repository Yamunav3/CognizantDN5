// ======================================
// Task 1: JavaScript Basics & Setup
// ======================================

console.log(
    "Welcome to the Community Portal"
);

window.onload = function ()
{
    alert(
        "Community Portal Loaded Successfully"
    );
};

// ======================================
// Task 2:
// Data Types and Operators
// ======================================

const eventName =
    "Music Festival";

const eventDate =
    "2026-12-20";

let availableSeats =
    50;

console.log(
`${eventName} on ${eventDate}
has ${availableSeats} seats`
);

// Registration decreases seats

availableSeats--;

console.log(
"Remaining Seats:",
availableSeats
);

// ======================================
// Task 5:
// Objects and Prototypes
// ======================================

function Event(
    id,
    name,
    category,
    location,
    date,
    seats
)
{
    this.id = id;
    this.name = name;
    this.category = category;
    this.location = location;
    this.date = date;
    this.seats = seats;
}

// Prototype Method

Event.prototype.checkAvailability =
function ()
{
    return this.seats > 0;
};

// ======================================
// Task 6:
// Arrays and Methods
// ======================================

const events =
[
    new Event(
        1,
        "Music Festival",
        "Music",
        "Hyderabad",
        "2026-12-20",
        50
    ),

    new Event(
        2,
        "Baking Workshop",
        "Workshop",
        "Bhimavaram",
        "2026-11-15",
        20
    ),

    new Event(
        3,
        "Tech Meetup",
        "Technology",
        "Vijayawada",
        "2026-10-10",
        30
    )
];

// push()

events.push(

    new Event(
        4,
        "Dance Show",
        "Music",
        "Vizag",
        "2026-09-10",
        15
    )
);

// filter()

const musicEvents =

events.filter(
    event =>
    event.category === "Music"
);

console.log(
"Music Events:",
musicEvents
);

// map()

const formattedEvents =

events.map(
    event =>
    `Workshop on ${event.name}`
);

console.log(
formattedEvents
);

// ======================================
// Task 5:
// Object.entries()
// ======================================

console.log(
"Object Entries:"
);

Object.entries(events[0])
.forEach(

([key, value]) =>
{
    console.log(
        key,
        value
    );
}

);

// ======================================
// Task 4:
// Functions
// ======================================

// addEvent()

function addEvent(event)
{
    events.push(event);
}

// registerUser()

function registerUser(
    name = "Guest"
)
{
    console.log(
        `${name} registered`
    );
}

// Higher Order Function

function filterEventsByCategory(
    category,
    callback
)
{
    const result =

    events.filter(
        event =>
        event.category === category
    );

    callback(result);
}

// ======================================
// Closure
// ======================================

function registrationCounter()
{
    let count = 0;

    return function ()
    {
        count++;

        return count;
    };
}

const totalRegistrations =
registrationCounter();

// ======================================
// Task 7:
// DOM Manipulation
// ======================================

const eventsContainer =

document.querySelector(
"#eventsContainer"
);

// Display Events
function displayEvents(eventList)
{
    eventsContainer.innerHTML = "";

    const today = new Date();

    eventList.forEach(event =>
    {
        const eventDate =
        new Date(event.date);

        if(
            event.seats > 0 &&
            eventDate >= today
        )
        {
            const card =
            document.createElement("div");

            card.className =
            "event-card";

            card.innerHTML =
            `
            <h3>${event.name}</h3>
            <p>${event.category}</p>
            <p>${event.location}</p>
            <p>${event.date}</p>
            <p>Seats: ${event.seats}</p>
            <button onclick="registerEvent(${event.id})">Register</button>
            <button onclick="cancelRegistration(${event.id})" style="background: red; margin-left: 5px;">Cancel</button>
            `;

            eventsContainer
            .appendChild(card);
        }
        else
        {
            console.log(
                `${event.name} hidden`
            );
        }
    });
}
// Initial Display

displayEvents(events);

// ======================================
// Task 3:
// Error Handling
// ======================================

function registerEvent(id)
{
    try
    {
        const event =

        events.find(
            event =>
            event.id === id
        );

        if(
            event.seats <= 0
        )
        {
            throw new Error(
                "Event Full"
            );
        }

        event.seats--;

        console.log(
            "Registered Successfully"
        );

        console.log(
            "Total Registrations:",
            totalRegistrations()
        );

        displayEvents(events);
    }

    catch(error)
    {
        console.log(
            error.message
        );
    }
}

// Cancel Registration

function cancelRegistration(id)
{
    const event =

    events.find(
        event =>
        event.id === id
    );

    event.seats++;

    displayEvents(events);
}
// ======================================
// Task 8: Event Handling
// ======================================

// onchange

document
.getElementById(
    "categoryFilter"
)
.onchange =
function ()
{
    const category =
    this.value;

    if(
        category === "All"
    )
    {
        displayEvents(events);
    }
    else
    {
        filterEventsByCategory(
            category,
            displayEvents
        );
    }
};

// keydown search

document
.getElementById(
    "searchInput"
)
.addEventListener(
    "keydown",
    function ()
    {
        const keyword =

        this.value
        .toLowerCase();

        const filtered =

        events.filter(
            event =>
            event.name
            .toLowerCase()
            .includes(keyword)
        );

        displayEvents(filtered);
    }
);

// ======================================
// Task 9:
// Async JS, Promises,
// Async/Await
// ======================================

const spinner =
document.getElementById(
    "spinner"
);

// Promise Style

fetch(
"https://jsonplaceholder.typicode.com/posts"
)
.then(
response =>
response.json()
)
.then(
data =>
{
    console.log(
        "Promise Data:"
    );

    console.log(data);
}
)
.catch(
error =>
{
    console.log(error);
}
);

// Async Await Style

async function loadEventsFromAPI()
{
    try
    {
        spinner.style.display =
        "block";

        const response =

        await fetch(
        "https://jsonplaceholder.typicode.com/posts"
        );

        const data =

        await response.json();

        console.log(
            "Async Await Data:"
        );

        console.log(data);
    }

    catch(error)
    {
        console.log(error);
    }

    finally
    {
        spinner.style.display =
        "none";
    }
}

loadEventsFromAPI();

// ======================================
// Task 10:
// Modern JavaScript Features
// ======================================

// Spread Operator

const clonedEvents =
[
    ...events
];

console.log(
    clonedEvents
);

// Destructuring

const
{
    name,
    category,
    seats
}
=
events[0];

console.log(
name,
category,
seats
);

// Default Parameter

function welcomeUser(
    userName = "Guest"
)
{
    console.log(
        `Welcome ${userName}`
    );
}

welcomeUser();
welcomeUser("Yamuna");

// ======================================
// Task 11:
// Working with Forms
// ======================================

const registerForm =

document.getElementById(
    "registerForm"
);

registerForm
.addEventListener(
"submit",

function(event)
{
    // prevent refresh

    event.preventDefault();

    const name =

    this.elements[
        "name"
    ].value;

    const email =

    this.elements[
        "email"
    ].value;

    const selectedEvent =

    this.elements[
        "event"
    ].value;

    const error =

    document.getElementById(
        "error"
    );

    const success =

    document.getElementById(
        "success"
    );

    error.innerHTML = "";
    success.innerHTML = "";

    // Validation

    if(
        name.trim() === ""
    )
    {
        error.innerHTML =
        "Name is required";

        return;
    }

    if(
        email.trim() === ""
    )
    {
        error.innerHTML =
        "Email is required";

        return;
    }

    if(
        selectedEvent === ""
    )
    {
        error.innerHTML =
        "Select an event";

        return;
    }

    success.innerHTML =
    "Form Validation Successful";

    // AJAX Task

    submitRegistration(
        {
            name,
            email,
            selectedEvent
        }
    );
}
);

// ======================================
// Task 12:
// AJAX & Fetch API
// ======================================

function submitRegistration(
    userData
)
{
    console.log(
        "Submitting Form"
    );

    console.log(
        "Payload:",
        userData
    );

    fetch(
    "https://jsonplaceholder.typicode.com/posts",
    {
        method: "POST",

        headers:
        {
            "Content-Type":
            "application/json"
        },

        body:
        JSON.stringify(
            userData
        )
    })
    .then(
        response =>
        response.json()
    )
    .then(
        data =>
        {
            console.log(data);

            setTimeout(
                () =>
                {
                    document
                    .getElementById(
                        "success"
                    )
                    .innerHTML =

                    "Registration Submitted Successfully";
                },
                2000
            );
        }
    )
    .catch(
        error =>
        {
            document
            .getElementById(
                "error"
            )
            .innerHTML =

            "Registration Failed";

            console.log(error);
        }
    );
}

// ======================================
// Task 13:
// Debugging & Testing
// ======================================

console.log(
    "Application Started"
);

console.log(
    "Events Loaded:",
    events
);

console.log(
    "Debugging Enabled"
);

/*

Chrome DevTools:

1. F12

2. Console Tab
   View Logs

3. Network Tab
   Inspect Fetch Requests

4. Sources Tab
   Add Breakpoints

5. Inspect Variables

*/

// ======================================
// Task 14:
// jQuery
// ======================================

$("#registerBtn")
.click(
function ()
{
    console.log(
        "jQuery Button Click"
    );

    $("#eventsContainer")
    .fadeOut(500)
    .fadeIn(500);
}
);

/*

Benefit of React/Vue:

1. Reusable Components

2. Better State Management

3. Faster Development

4. Easier Maintenance

*/