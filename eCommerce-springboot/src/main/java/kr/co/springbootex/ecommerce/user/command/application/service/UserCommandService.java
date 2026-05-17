package kr.co.springbootex.ecommerce.user.command.application.service;

import jakarta.transaction.Transactional;
import kr.co.springbootex.ecommerce.user.command.application.dto.PasswordChangeRequestDTO;
import kr.co.springbootex.ecommerce.user.command.application.dto.UserLoginRequestDTO;
import kr.co.springbootex.ecommerce.user.command.application.dto.UserSignupRequestDTO;
import kr.co.springbootex.ecommerce.user.command.application.dto.UserUpdateRequestDTO;
import kr.co.springbootex.ecommerce.user.command.domain.entity.User;
import kr.co.springbootex.ecommerce.user.command.domain.repository.UserRepository;
import kr.co.springbootex.ecommerce.user.query.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandService {
    private final UserRepository userRepository;

    // 회원가입
    @Transactional
    public void signup(UserSignupRequestDTO userSignupRequestDTO){
        // ID 체크
        if(userRepository.existsById(userSignupRequestDTO.getIdUser())){
            throw new IllegalArgumentException("이미 존재하는 ID입니다.");
        }

        // 이메일 체크
        if(userRepository.existsByNmEmail(userSignupRequestDTO.getNmEmail())){
            throw new IllegalArgumentException("이미 존재하는 Email입니다.");
        }

        User user = new User(
                userSignupRequestDTO.getIdUser(),
                userSignupRequestDTO.getNmUser(),
                userSignupRequestDTO.getNmPaswd(),
                userSignupRequestDTO.getNoMobile(),
                userSignupRequestDTO.getNmEmail(),
                "st03",
                "10"
        );

        userRepository.save(user);
    }

    // 로그인
    public UserResponseDTO login(UserLoginRequestDTO userLoginRequestDTO){
        // ID가 존재하는가
        User user = userRepository.findById(userLoginRequestDTO.getIdUser())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID입니다."));

        // 비밀번호 비교
        if(!user.getNmPaswd().equals(userLoginRequestDTO.getNmPaswd())){
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }

        // 상태: 정상이 아니면 제한
        if (!"st01".equals(user.getStStatus())) {
            throw new IllegalStateException("잘못된 접근입니다.");
        }

        return UserResponseDTO.builder()
                .idUser(user.getIdUser())
                .nmUser(user.getNmUser())
                .noMobile(user.getNoMobile())
                .nmEmail(user.getNmEmail())
                .stStatus(user.getStStatus())
                .cdUserType(user.getCdUserType())
                .build();
    }

    // 회원 정보 수정
    @Transactional
    public void updateMyInfo(String idUser, UserUpdateRequestDTO userUpdateRequestDTO){

        // 사용자를 찾았는가
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 객체 값 바꾸기
        user.setNmUser(userUpdateRequestDTO.getNmUser());
        user.setNoMobile(userUpdateRequestDTO.getNoMobile());
        user.setNmEmail(userUpdateRequestDTO.getNmEmail());
    }

    // 비밀번호 변경
    @Transactional
    public void changePassword(String idUser, PasswordChangeRequestDTO dto) {

        // 사용자를 찾았는가
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 현재 비밀번호와 동일한가
        if (!user.getNmPaswd().equals(dto.getCurrentPassword())) {
            throw new IllegalArgumentException("현재 비밀번호가 일치하지 않습니다.");
        }

        // 새 비밀번호로 변경
        user.setNmPaswd(dto.getNewPassword());
    }

    //  탈퇴 요청
    @Transactional
    public void requestWithdrawal(String idUser) {

        // 사용자를 찾았는가
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 탈퇴요청(st04)'으로 변경
        user.setStStatus("st04");
    }

    // 사용자 단건 조회
    public UserResponseDTO getMyInfo(String idUser){

        // 사용자를 찾았는가
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        return UserResponseDTO.builder()
                .idUser(user.getIdUser())
                .nmUser(user.getNmUser())
                .noMobile(user.getNoMobile())
                .nmEmail(user.getNmEmail())
                .stStatus(user.getStStatus())
                .cdUserType(user.getCdUserType())
                .build();
    }

    // 관리자: 가입, 탈퇴 요청
    @Transactional
    public void approveUserRequest(String idUser) {

        // 사용자를 찾았는가
        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        if ("st03".equals(user.getStStatus())) {
            user.setStStatus("st01"); // 가입요청 -> 정상
        } else if ("st04".equals(user.getStStatus())) {
            user.setStStatus("st02"); // 탈퇴요청 -> 해지
        } else {
            throw new IllegalStateException("승인할 수 없는 상태입니다.");
        }
    }

    // 관리자: 사용자 상태 변경
    @Transactional
    public void changeUserStatus(String userId, String status) {

        // 사용자를 찾았는가
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        user.setStStatus(status);
    }

    // 관리자: 사용자 권한 변경
    @Transactional
    public void changeUserRole(String userId, String roleType) {

        // 사용자를 찾았는가
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        user.setCdUserType(roleType);
    }
}
