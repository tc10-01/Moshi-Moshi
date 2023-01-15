package UI;

import Entity.User;

public class PublicProfileController {
    private User userOwner;
    private String displayName;
    private String bio;
    private String status;
    private String comment;
    private ProfileUseCase profileUseCase;

    public PublicProfileController(User userOwner){
        profileUseCase = new ProfileUseCase(userOwner);
        this.userOwner = userOwner;
        this.displayName = profileUseCase.getDisplayName();
        this.bio = profileUseCase.getBio();
        this.status = profileUseCase.getStatus();
        this.comment = profileUseCase.getComment();
    }
    public String getDisplayName(){
        return displayName;
    }
    public String getBio(){
        return bio;
    }
    public String getStatus(){
        return status;
    }
    public String getComment(){
        return comment;
    }
    public void modifyUserProfile(String modificationLocation, String modification){
        if (modificationLocation.equals("name")){
            profileUseCase.modifyDisplayName(modification);
        }
        else if (modificationLocation.equals("status")){
            profileUseCase.modifyStatus(modification);
        }
        else if (modificationLocation.equals("comment")){
            profileUseCase.modifyComment(modification);
        }
        else {
            profileUseCase.modifyBio(modification);
        }

    }

}
