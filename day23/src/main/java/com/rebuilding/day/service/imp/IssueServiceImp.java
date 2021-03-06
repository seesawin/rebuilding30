package com.rebuilding.day.service.imp;

import com.rebuilding.day.entity.Issue;
import com.rebuilding.day.repository.IssueRepository;
import com.rebuilding.day.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IssueServiceImp implements IssueService {

    private IssueRepository issueRepository;

    @Override
    public List<Issue> queryAll() {
        return new ArrayList<Issue>() {{
            add(new Issue());
        }};
    }

    @Override
    public Issue queryById(Long id) {
        return issueRepository.findById(id);
    }

    @Override
    public Issue create(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public Issue findOrSave(Map<String, String> map) {
        Issue issue = new Issue();
        issue.setTitle(map.get("title"));
        if (map.get("id") == null) {
            return issueRepository.save(issue);
        } else {
            issue.setId(Long.valueOf(map.get("id")));
            return this.queryById(issue.getId());
        }
    }

    @Autowired
    public void setIssueRepository(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }
}
