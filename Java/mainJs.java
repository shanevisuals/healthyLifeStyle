function myFunction(x) {
    x.classList.toggle("change");

    var nav = document.getElementById("mobile-nav");
    if (nav.style.display === 'flex' || nav.style.display === '') {
        nav.style.display = 'none';
    } else {
        nav.style.display = 'flex';
    }
}


const processEntries = (formId) => {
    const form = $("#" + formId);

    // get form controls to check for validity
    const inputs = form.querySelectorAll('input');

    // check user entries for validity
    let isValid = true;

    inputs.forEach(input => {
        const label = form.querySelector(`label[for=${input.id}]`);
        const validationSpan = label.nextElementSibling;

        if (input.value === "") {
            // Use innerHTML to update the content of the span element
            validationSpan.innerHTML = "<span style='color: red;'>This field is required.</span>";
            isValid = false;
        } else {
            validationSpan.innerHTML = ""; // Clear the content
        }
    });

    // submit the form if all fields are valid
    if (isValid) {
        submitForm(); // Call the function to handle form submission
    }
};

const submitForm = () => {
   
    console.log("Form submitted successfully");
}

const resetForm = (formId) => {
    const form = $("#" + formId);
    form.reset();

    const inputs = form.querySelectorAll('input');
    inputs.forEach(input => {
        const label = form.querySelector(`label[for=${input.id}]`);
        const validationSpan = label.nextElementSibling;
        validationSpan.textContent = "*";
    });

    // Set focus to the first input field
    inputs[0].focus();
};

document.addEventListener("DOMContentLoaded", () => {
    $("#log-in").addEventListener("submit", (event) => {
        processEntries("log-in");
        event.preventDefault(); // Prevent the default form submission
    });
    $("#registerationForm").addEventListener("submit", (event) => {
        processEntries("registerationForm");
        event.preventDefault(); // Prevent the default form submission
    });

    // Add your other event listeners here
    document.getElementById("bmiForm").addEventListener("submit", function (event) {
        event.preventDefault(); // Prevent the form from submitting and refreshing the page
        // Add your BMI form submission logic here
    });

    document.getElementById("productForm").addEventListener("submit", function (event) {
        event.preventDefault();
        addProduct();
    });
    
    const toggleButton = document.getElementById("toggle-password");
    const passwordInput = document.getElementById("password");

    toggleButton.addEventListener("click", function () {
        togglePasswordVisible(passwordInput, toggleButton);
    });

    document.getElementById("log-in").addEventListener("submit", function (event) {
        event.preventDefault(); // Prevent the default form submission
        processEntries("log-in");
    });
});

function togglePasswordVisible() {
    var passwordInput = document.getElementById("password");
    var toggleButton = document.getElementById("toggle-password");

    if (passwordInput.getAttribute("type") === "password") {
        passwordInput.setAttribute("type", "text");
        toggleButton.textContent = "Hide";
    } else {
        passwordInput.setAttribute("type", "password");
        toggleButton.textContent = "Show";
    }
}

function focusInput(inputId) {
    document.getElementById(inputId).focus();
}

    
    
    
document.addEventListener("DOMContentLoaded", function () {

    document.getElementById("bmiForm").addEventListener("submit", function (event) {
        event.preventDefault(); // Prevent the form from submitting and refreshing the page

        const height = parseFloat(document.getElementById('height').value);
        const weight = parseFloat(document.getElementById('weight').value);
        const resultElement = document.getElementById('bmiResult');

        if (isNaN(height) || isNaN(weight) || height <= 0 || weight <= 0) {
            resultElement.innerHTML = 'Please enter valid height and weight.';
        } else {
            const bmi = weight / ((height / 100) ** 2);
            const roundedBMI = bmi.toFixed(1);

            let bmiCategory;

            if (bmi < 18.5) {
                bmiCategory = 'Underweight';
            } else if (bmi < 25) {
                bmiCategory = 'Normal weight';
            } else if (bmi < 30) {
                bmiCategory = 'Overweight';
            } else {
                bmiCategory = 'Obese';
            }

            resultElement.innerHTML = `Your BMI is ${roundedBMI}. Category: ${bmiCategory}.`;
        }
    });
});



    
    document.getElementById("productForm").addEventListener("submit", function (event) {
        event.preventDefault();
        addProduct();
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const listItems = document.querySelectorAll('.list-item');
    const imageDisplay = document.getElementById('imageDisplay');

    listItems.forEach(item => {
        item.addEventListener('mouseenter', function () {
            const imagePath = this.getAttribute('data-image');
            changeImage(imagePath);
        });

        item.addEventListener('mouseleave', function () {
            changeImage('path-to-default-image.jpg');
        });
    });

    function changeImage(path) {
        imageDisplay.style.transform = 'scale(1.1)';
        setTimeout(() => {
            imageDisplay.src = path;
            imageDisplay.style.transform = 'scale(1)';
        }, 500);
    }
});

let products = [];

function addProduct() {
    const productName = document.getElementById("productName").value;
    const productPrice = document.getElementById("productPrice").value;

    if (productName && productPrice) {
        const product = { name: productName, price: productPrice };
        products.push(product);
        displayProducts();
        clearForm();
    } else {
        alert("Please enter product name and price.");
    }
}

function displayProducts() {
    const productTable = document.getElementById("productTable");
    productTable.innerHTML = "";

    for (const product of products) {
        const row = productTable.insertRow();
        const cell1 = row.insertCell(0);
        const cell2 = row.insertCell(1);
        const cell3 = row.insertCell(2);

        cell1.textContent = product.name;
        cell2.textContent = product.price;

        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";
        deleteButton.onclick = function () {
            deleteProduct(products.indexOf(product));
        };

        cell3.appendChild(deleteButton);
    }
}

function deleteProduct(index) {
    products.splice(index, 1);
    displayProducts();
}

function clearForm() {
    document.getElementById("productName").value = "";
    document.getElementById("productPrice").value = "";
}

var slideIndex = 1;

showSlides(slideIndex);

function plusSlides(n) {
    showSlides(slideIndex += n);
}

function showSlides(n) {
    var i;
    var slides = document.getElementsByClassName("mySlides");

    if (n > slides.length) {
        slideIndex = 1;
    } else if (n < 1) {
        slideIndex = slides.length;
    }

    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    slides[slideIndex - 1].style.display = "block";

    updateNutritionInfo(slides[slideIndex - 1].id);
}


function updateNutritionInfo(slideId) {
    var nutritionInfoContainer = document.getElementById("nutritionInfo");
    var text = "";

    switch (slideId) {
        case "slide1":
            text = "<ul>" +  "<li><strong>Chicken:</strong> Chicken is a good source of protein, essential for muscle growth and repair.</li>" + "<li><strong>Chorizo:</strong> Chorizo is a type of sausage that adds a rich and smoky flavor to the jambalaya.</li>" + "<li><strong>Rice:</strong> Rice is a good source of carbohydrates, providing energy for the body.</li>" + "<li><strong>Vegetables:</strong> Jambalaya often includes a variety of vegetables like bell peppers, onions, celery, and tomatoes.</li>" + "<li><strong>Spices:</strong> The use of spices like paprika, cayenne pepper, thyme, and bay leaves not only adds flavor but may also have health benefits.</li>" + "</ul>" + "<p><strong>Overall Nutritional Considerations:</strong> Jambalaya can be a balanced meal when prepared with a variety of colorful vegetables, lean protein, and whole grains.</p> " 
            break;
        case "slide2":
            text = "<ul>" + "<li><strong>Carrots:</strong> Carrots are rich in beta-carotene, a precursor to vitamin A, which is essential for vision, immune function, and skin health.</li>" + "<li>They provide dietary fiber, promoting digestive health.</li>" + "<li>Carrots also contain vitamins C and K, as well as potassium.</li>" + "<li><strong>Lentils:</strong> Lentils are an excellent source of plant-based protein, making them a great choice for vegetarians and vegans.</li>" + "<li>They are rich in fiber, promoting satiety and supporting digestive health.</li>" + "<li>Lentils also provide a variety of essential nutrients, including iron, folate, potassium, and magnesium.</li>" + "<li><strong>Spices:</strong> The spices used in the soup, such as cumin, coriander, ginger, or turmeric, not only add flavor but also contribute potential health benefits.</li>" + "<li>For example, ginger has anti-inflammatory properties, while turmeric contains curcumin, known for its antioxidant and anti-inflammatory effects.</li>" + "<li><strong>Broth:</strong> The broth used in the soup can add both flavor and nutrients. Opting for a vegetable broth can keep the soup vegetarian/vegan, while chicken or bone broth provides additional protein and minerals.</li>" + "<br><p><strong>Overall Nutritional Considerations:</strong> Carrot and lentil soup is generally low in fat and can be a good source of complex carbohydrates, making it a filling and satisfying meal.</p>" + "<br> <li>It's a good source of dietary fiber, which supports digestive health and helps regulate blood sugar levels.</li>" + "<li>The soup is nutrient-dense, providing a range of vitamins, minerals, and antioxidants.</li>" + "<br> <p><strong>Additional Ingredients:</strong> Some recipes may include additional ingredients like onions, garlic, or tomatoes, adding more layers of flavor and nutritional benefits.</p>" + "<br> <li>Consider garnishing the soup with fresh herbs, such as cilantro or parsley, for added freshness and a boost of micronutrients.</li>" + 
                "</ul>";
            break;
        case "slide3":
            text = "<ul>" + "<li><strong>Chicken:</strong> Chicken is a lean source of protein, essential for muscle repair and overall body function.</li>" + "<li>It contains important vitamins and minerals such as B vitamins (especially niacin and B6), phosphorus, and selenium.</li>" + "<li><strong>Noodles:</strong> Noodles provide carbohydrates, which are a primary source of energy for the body.</li>" + "<li>Opting for whole grain noodles adds dietary fiber, promoting digestive health and providing longer-lasting energy.</li>" + "<li><strong>Broth:</strong> Chicken broth, especially if homemade, can contain nutrients extracted from the bones, such as collagen, gelatin, and minerals.</li>" + "<li>Broth is hydrating and can help soothe a sore throat or congestion.</li>" + 
            "<li><strong>Vegetables:</strong> Many chicken noodle soup recipes include vegetables like carrots, celery, and onions.</li>" + 
            "<li>Vegetables contribute vitamins, minerals, and antioxidants to the soup, enhancing its overall nutritional profile.</li>" +
            "<li><strong>Herbs and Spices:</strong> Herbs like parsley, thyme, and dill, as well as spices like black pepper, not only add flavor but also provide additional vitamins and antioxidants.</li>" +
            "<br><p><strong>Overall Nutritional Considerations:</strong> Chicken noodle soup is generally low in fat, especially if you remove any visible fat from the chicken.</p>" +
            "<br> <li>It can be a good source of essential nutrients, including protein, carbohydrates, vitamins (such as vitamin A and vitamin C), and minerals (such as potassium).</li>" +
            "<li>The warm broth can be soothing and hydrating, making it a popular choice during cold or flu seasons.</li>" +
            "<br><p><strong>Health Benefits:</strong> The warmth of the soup may have a comforting effect and can help with hydration, especially if you're not feeling well.</p>" +
            "<br> <li>Chicken noodle soup is often recommended as a home remedy for colds and flu due to its potential to alleviate congestion and provide nourishment.</li>" +
                "</ul>";
            break;
        case "slide4":
            text = "<ul>" + "<li><strong>Lentils:</strong> Lentils are an excellent source of plant-based protein, making them a valuable component for vegetarians and vegans.</li>" +
            "<li>They are high in dietary fiber, supporting digestive health and providing a feeling of fullness.</li>" +
            "<li>Lentils also offer a range of essential nutrients, including iron, folate, potassium, and manganese.</li>" +
            "<li><strong>Root Vegetables:</strong> Root vegetables such as carrots, sweet potatoes, and parsnips are rich in complex carbohydrates, providing a good source of energy.</li>" +
            "<li>They are high in dietary fiber, vitamins (like vitamin A and vitamin C), and minerals (such as potassium).</li>" +
            "<li><strong>Spices:</strong> The use of spices in the casserole not only adds flavor but can also contribute health benefits.</li>" +
            "<li>For example, some spicy ingredients like chili peppers may boost metabolism and have anti-inflammatory properties.</li>" +
            "<li><strong>Tomatoes:</strong> Tomatoes, often used in casseroles, provide vitamins (especially vitamin C and vitamin A), antioxidants (lycopene), and minerals.</li>" +
            "<li><strong>Herbs:</strong> Adding herbs like thyme, rosemary, or cilantro not only enhances the taste but also contributes additional vitamins and antioxidants.</li>" +
            "<br><p><strong>Overall Nutritional Considerations:</strong> A spicy root and lentil casserole is likely to be rich in plant-based protein, dietary fiber, vitamins, and minerals.</p>" +
            "<br> <li>The dish can be relatively low in fat, especially if you limit the use of added fats or oils.</li>" +
            "<br><p><strong>Additional Ingredients:</strong> Depending on the recipe, you might find additional ingredients like onions, garlic, or bell peppers, each contributing their nutritional benefits.</p>" +
            "<br> <li>Consider using whole spices or fresh herbs to add flavor without relying on excess salt.</li>" +
            "<br><p><strong>Serving Suggestions:</strong> Pairing the casserole with a whole grain, such as brown rice or quinoa, can increase the overall nutritional content.</p>" +
            "<br> <li>Garnishing with fresh herbs or a squeeze of lemon before serving can add a burst of freshness and additional nutrients.</li>" +
                "</ul>";
            break;
        case "slide5":
            text = "<ul>" + "<li><strong>Lentils:</strong> Lentils are an excellent source of plant-based protein, making them a valuable component for vegetarians and vegans.</li>" +
            "<li>They are high in dietary fiber, supporting digestive health and providing a feeling of fullness.</li>" +
            "<li>Lentils also offer a range of essential nutrients, including iron, folate, potassium, and manganese.</li>" +
            "<li><strong>Spinach:</strong> Spinach is rich in vitamins and minerals, including vitamin A, vitamin K, folate, and iron.</li>" +
            "<li>It adds vibrant color to the dish and contributes to its nutritional profile.</li>" +
            "<li><strong>Sweet Potato:</strong> Sweet potatoes are a nutritious source of complex carbohydrates, providing energy and fiber.</li>" +
            "<li>They are rich in vitamins like vitamin A, vitamin C, and B vitamins.</li>" +
            "<li><strong>Spices:</strong> The use of spices in the Dhal not only adds flavor but can also contribute health benefits.</li>" +
            "<li>For example, some spices like cumin, coriander, and turmeric may have antioxidant and anti-inflammatory properties.</li>" +
            "<br><p><strong>Overall Nutritional Considerations:</strong> A Spinach, Sweet Potato, and Lentil Dhal is likely to be rich in plant-based protein, dietary fiber, vitamins, and minerals.</p>" +
            "<br> <li>The dish can be relatively low in fat, especially if you limit the use of added fats or oils.</li>" +
            "<br><p><strong>Additional Ingredients:</strong> Depending on the recipe, you might find additional ingredients like onions, garlic, or tomatoes, each contributing their nutritional benefits.</p>" +
            "<br> <li>Consider using whole spices or fresh herbs to add flavor without relying on excess salt.</li>" +
            "<br><p><strong>Serving Suggestions:</strong> Pairing the Dhal with a whole grain, such as brown rice or quinoa, can increase the overall nutritional content.</p>" +
            "<br> <li>Garnishing with fresh herbs or a squeeze of lemon before serving can add a burst of freshness and additional nutrients.</li>" +
                "</ul>";
            break;
        default:
            text = "";
    }

    nutritionInfoContainer.innerHTML = text;
}

function updateDateTime() {
    var currentDate = new Date();
    var formattedDate = currentDate.toLocaleDateString('en-US', { year: 'numeric', month: 'long', day: 'numeric' });

    document.getElementById('lastUpdated').textContent = formattedDate;
}

updateDateTime();

setInterval(updateDateTime, 60000);


