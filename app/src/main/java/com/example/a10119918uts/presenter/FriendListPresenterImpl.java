package com.example.a10119918uts.presenter;

import com.example.a10119918uts.model.FriendListModel;
import com.example.a10119918uts.view.FriendListView;

import java.util.ArrayList;
import java.util.List;

public class FriendListPresenterImpl implements FriendListPresenter {
    private FriendListView view;
    private List<FriendListModel> friendLists = new ArrayList<>();
    private int no = 5;

    public FriendListPresenterImpl(FriendListView view) {
        this.view = view;
        setData();
    }

    @Override
    public void load() {
        view.onLoad(friendLists);
    }

    public void setData() {
        FriendListModel friendList1 = new FriendListModel();
        friendList1.setId(1);
        friendList1.setNama("Aldi Nugraha");
        friendList1.setImagename("ic_friend_aldi");
        friendLists.add(friendList1);

        FriendListModel friendList2 = new FriendListModel();
        friendList2.setId(2);
        friendList2.setNama("Muhammad Nurkholiq");
        friendList2.setImagename("ic_friend_kholiq");
        friendLists.add(friendList2);

        FriendListModel friendList3 = new FriendListModel();
        friendList3.setId(3);
        friendList3.setNama("Muhammad Fauzan F.");
        friendList3.setImagename("ic_friend_fauzan");
        friendLists.add(friendList3);

        FriendListModel friendList4 = new FriendListModel();
        friendList4.setId(4);
        friendList4.setNama("Umar Said A. P.");
        friendList4.setImagename("ic_friend_umar");
        friendLists.add(friendList4);
    }
}
