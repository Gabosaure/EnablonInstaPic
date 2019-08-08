package com.GabCorp.enablonpicapp.repositories;

import android.arch.lifecycle.MutableLiveData;
import com.GabCorp.enablonpicapp.models.InstaPic;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InstaPicRepositoryTest {

    InstaPicRepository repoTest;

    @Test
    public void InstaPicRepository_createInstance_returnsTrue(){
        repoTest = InstaPicRepository.getInstance();
        assertNotNull(repoTest);
    }


    @Test
    public void InstaPicRepository_getPicList_ReturnsTrue(){

        MutableLiveData<List<InstaPic>> list;
        repoTest = InstaPicRepository.getInstance();
        list = repoTest.getInstaPicList();
        assertNotNull(list);
        // Issue testing live retrieval due to delay on the enqueue request
        //assertEquals(5, list.getValue().size());

    }

    @Test
    public void InstaPicRepository_sendRequest_ReturnsTreu(){


    }
}