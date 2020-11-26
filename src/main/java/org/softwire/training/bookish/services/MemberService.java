package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService extends DatabaseService {

    public List<Member> getAllMembers() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM member")
                        .mapToBean(Member.class)
                        .list()
        );
    }

    public void addMember(Member Member) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO member (name) VALUES (:name)")
                        .bind("name", Member.getName())
                        .execute()
        );
    }

    public void deleteMember(int memberId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM member WHERE id = :id")
                        .bind("id", memberId)
                        .execute()
        );
    }

    public void updateMember(int memberId, String memberName) {
        jdbi.useHandle(handle ->
                handle.createUpdate("UPDATE member SET name = :name WHERE id = :id")
                        .bind("id", memberId)
                        .bind("name", memberName)
                        .execute()
        );
    }
}
