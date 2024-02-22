// 회원가입 유효성 검사

// 이메일
let emailChk = false;

function inputEmail() {
  let regEmail = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$/;
  let email = $(".user_email").val();

  if (email == "") {
    $(".emailMsg").text("이메일을 입력해주세요.");
    emailChk = false;
    return;
  } else if (false === regEmail.test(email)) {
    $(".emailMsg").text("이메일 형식에 맞지않습니다.");
    emailChk = false;
    return;
  } else {
    $(".emailMsg").text("  ");
    emailChk = true;
  }
}

// 비밀번호 유효성 검사
let pwChk = false;

function inputPw() {
  let regPw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/;
  let pw = $(".user_pw").val();

  if (pw == "") {
    $(".pwMsg").text("비밀번호를 입력해주세요.");
    pwChk = false;
    return;
  } else if (false === regPw.test(pw)) {
    $(".pwMsg").text("영문,숫자,특수문자 포함 8자리 이상이여야 합니다.");
    pwChk = false;
    return;
  } else if (true === regPw.test(pw)) {
    $(".pwMsg").text("  ");
    pwChk = true;
  } else {
    $(".pwMsg").text("  ");
    pwChk = true;
  }
}

// 비밀번호 확인 유효성 검사

let pwConfirm = false;

function inputPwChk() {
  let PwChk = $(".user_pw").val();

  if ($(".user_pwChk").val() != PwChk) {
    $(".ChkPwMsg").text("동일한 비밀번호를 입력해주세요");
    pwConfirm = false;
    return;
  } else {
    $(".ChkPwMsg").text("비밀번호가 일치합니다.");
    $(".ChkPwMsg").css({ color: "blue", "font-size": "13px" });
    pwConfirm = true;
    return;
  }
}

// 약관동의 체크박스 
/* 체크박스 전체 선택, 전체 해제 */
$('.chkbox_group').on('click', '#chk_all', function() {
  console.log(this);
  const checked = $(this).is(':checked');

  if (checked) {
    $(this).parents('.chkbox_group').find('input').prop('checked', true);
  } else {
    $(this).parents('.chkbox_group').find('input').prop('checked', false);
  }
});

/* 개별 체크박스 항목이 선택 해제 될 때 전체선택 해제 */
$('.chkbox_group').on('click', '.chk', function() {
  let is_checked = true;

  $('.chkbox_group .chk').each(function() {
    is_checked = is_checked && $(this).is(':checked');
  });

  $('#chk_all').prop('checked', is_checked);
});


// 버튼 클릭시 이용약관 유효성검사 후 넘어가기 
  $('.joinBtn').on('click', '.joinSubmit', function() {

    let chk1 = document.getElementById('chk1');
    
    if(chk1.checked===false) {
        alert("이용약관 동의는 필수사항입니다");
        return;
    }
  
    let chk2 = document.getElementById('chk2');

    if(chk2.checked===false) {
        alert("서비스 이용약관 동의는 필수사항입니다.");
        return;
    }

    let chk3 = document.getElementById('chk3');

    if(chk3.checked===false) {
        alert("개인정보 처리방침 동의는 필수사항입니다");
        return;
    }

    document.user_joinForm.submit();

  });

