$(document).ready(function(){
			var width=1600;
			var animationSpead=500;
			var pause=2000;
			var currentSlide=1;
			
			var $slider=$("#contentİmageContener");
			var $sliderContener=$slider.find(".slides");
			var $slide=$sliderContener.find(".slide");
			
			
			setInterval(function(){

				$sliderContener.animate({'margin-left':'-='+width},animationSpead ,function(){
					currentSlide++;
					
					if(currentSlide===$slide.length){
						
						currentSlide=1;
						$sliderContener.css('margin-left',0);
					}
			} );
	},pause);
});

$(function(){
	$("#deneme").datepicker();

});