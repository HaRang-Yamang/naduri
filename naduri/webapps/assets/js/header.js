// /* map api */
// var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
// var options = { //지도를 생성할 때 필요한 기본 옵션
// 	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
// 	level: 3 //지도의 레벨(확대, 축소 정도)
// };

// var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴


/* hot keyword filter */

    $(document).ready(function(){
        $('.list').click(function(){
            const value = $(this).attr('data-filter');
            if (value == 'All'){
            $('.hotSpot').show('1000');
        } else {
            $('.hotSpot').not('.'+value).hide('1000');
            $('.hotSpot').filter('.'+value).show('1000');
        }
    })

        // add active class on selected item

        $('.list').click(function (){
            $(this).addClass('active').siblings().removeClass('active');
        })
    })
    
/* user menu */ 
const userMenu = document.querySelector('.user_menu');
const profile = document.querySelector('.profile');

profile.addEventListener('click', () => {
    userMenu.classList.toggle('active');
});

/* search */

    const search = document.querySelector('search_val').value;
	const searchResult = document.querySelector('#result');


    function goSearch() {
    	location.href = "/naduri/search.do?search=" + searchResult;
    }
