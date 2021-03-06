package com.rebuilding.day15.service.imp;

import com.rebuilding.day15.entity.Issue;
import com.rebuilding.day15.repository.IssueRepository;

public class IssueServiceImp {

    private IssueRepository repository;

    public Issue create(Issue issue) {
        Issue _issue = repository.find(issue);
        Issue newIssue = new Issue();
        newIssue.setState(_issue.getState());
        return repository.save(_issue);
    }

    /**
     * IssueRepository的注入方法
     */
    public void setRepository(IssueRepository repository) {
        this.repository = repository;
    }
}
