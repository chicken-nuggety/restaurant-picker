const restaurantForm = document.getElementById("restaurant-form");
const restaurantRandom = document.getElementById("restaurant-random");
const restaurantResult = document.getElementById("restaurant-result");
const jsConfetti = new JSConfetti();

restaurantForm.addEventListener("submit", onRestaurantSubmit);
restaurantRandom.addEventListener("submit", chooseRandomRestaurant);


function onRestaurantSubmit(e) {
  e.preventDefault();
  const data = new FormData(e.target);
  const dataObject = Object.fromEntries(data.entries());
  // console.log(dataObject);

  let restaurantName = dataObject["restaurantName"];
  // console.log(restaurantName);
  const formData = { name: restaurantName };
  postRestaurant(formData);

  restaurantForm.reset(); // Reset form after submit
}

async function chooseRandomRestaurant(e) {
  e.preventDefault();

  result = await getRestaurant();
  // Check if output is not empty
  if (result) {
    let node = document.createTextNode(result.name);
    restaurantResult.innerHTML = ''; // Clear existing content in <p> tag first
    restaurantResult.appendChild(node);

    jsConfetti.addConfetti({
      emojis: ['🌈', '⚡️', '💥', '✨', '💫', '🌸'],
    });
  }
}

async function postRestaurant(data) {
  try {
    const response = await fetch("http://localhost:8080/backend/restaurant", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });

    const result = await response.json();
    alert("Thank you for your restaurant input :)")
    console.log("Success:", result);
  } catch (error) {
    console.error("Error:", error);
  }
}

async function getRestaurant() {
  try {
    const response = await fetch("http://localhost:8080/backend/restaurant/random", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (response.status == 200) {
      const result = await response.json();
      console.log("Success:", result);
      return result;
    }
    else {
      alert("There are no current inputs, please submit a restaurant.");
      return false;
    }
  } catch (error) {
    console.error("Error:", error);
  }
}