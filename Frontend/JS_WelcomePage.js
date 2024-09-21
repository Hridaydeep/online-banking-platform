const slogans = [
    "Unlock the Power of Wealth with Us . . .",
    "DeepWealth: Trust, Growth, Prosperity . . .",
    "Secure Your Future with DeepWealth . . .",
    "Empowering Your Financial Journey . . ."
];

let currentIndex = 0;

function typeSlogan(slogan) {
    const sloganContainer = document.createElement('div');
    sloganContainer.className = 'slogan';
    document.querySelector('.main-section').appendChild(sloganContainer);

    let index = 0;
    sloganContainer.style.opacity = 0; // Start with hidden opacity

    const typingInterval = setInterval(() => {
        sloganContainer.textContent += slogan[index];
        index++;

        if (index === slogan.length) {
            clearInterval(typingInterval);
            setTimeout(() => {
                removeSlogan(sloganContainer);
            }, 1500); // Pause before next slogan
        }
    }, 50); // Speed of typing

    // Fade in the slogan
    setTimeout(() => {
        sloganContainer.style.opacity = 1; // Fade in
    }, 0); // Immediate effect
}

function removeSlogan(sloganContainer) {
    const removingInterval = setInterval(() => {
        sloganContainer.textContent = sloganContainer.textContent.slice(0, -1);
        
        if (sloganContainer.textContent.length === 0) {
            clearInterval(removingInterval);
            sloganContainer.remove(); // Remove the container
            currentIndex = (currentIndex + 1) % slogans.length; // Update the index
            typeSlogan(slogans[currentIndex]); // Type the next slogan
        }
    }, 25); // Speed of removing
}

document.addEventListener('DOMContentLoaded', () => {
    typeSlogan(slogans[currentIndex]);
});
