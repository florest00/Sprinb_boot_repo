document.querySelectorAll('#layout > .sidebar > nav > ul > li > a').forEach(aTag => {
    aTag.addEventListener('click', function() {
        this.parentNode.classList.toggle('active');
    });
});
