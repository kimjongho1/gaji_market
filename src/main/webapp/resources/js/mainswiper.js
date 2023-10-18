const swiper = new Swiper('.swiper', {
    // Optional parameters

	slidesPerView: 3, 
    spaceBetween: 10, 
    loop: true,
	
	autoplay: {
   delay: 5000,
 },
	
    // If we need pagination
    pagination: {
      el: '.swiper-pagination',
      clickable : true,
      type: 'bullets',
    },

    // Navigation arrows
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },

    // And if we need scrollbar
    scrollbar: {
      el: '.swiper-scrollbar',
    },
  });

