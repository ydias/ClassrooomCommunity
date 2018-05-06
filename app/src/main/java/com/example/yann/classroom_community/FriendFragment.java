package com.example.yann.classroom_community;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class FriendFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private List<com.example.yann.classroom_community.BDD2.Friend> friends;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FriendFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FriendFragment newInstance(int columnCount) {
        FriendFragment fragment = new FriendFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);

        getFriends();

        //FriendContent.addFriends(friends);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyFriendRecyclerViewAdapter(FriendContent.FRIENDS, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFriendFragmentInteraction(FriendContent.Friend friend);
    }

    //Code connexion bdd

    public static boolean checkConnection(Context ctx) {

        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected() || (networkInfo.getType() != ConnectivityManager.TYPE_WIFI && networkInfo.getType() != ConnectivityManager.TYPE_MOBILE)) {

            //No internet connection
            return false;

        } else
            return true;
    }

    public static final String TAG = "YOUR-TAG-NAME";
    //ProgressDialog pDialog;
    public void getFriends() {



        /*
        pDialog = new ProgressDialog(this.getActivity());
        pDialog.setMessage("Getting list of friends...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();*/
        String s = String.valueOf(checkConnection(this.getContext()));
        Log.i("CONNEXION",s);

        //String urlString = "http://localhost/classroom_server/getFriends.php";
        String urlString ="http://192.168.0.12/classroom_server/getQuestions.php?key=1235";

        Log.i("ACTIVITY",getActivity().toString());

        Ion.with(getActivity()).load(urlString).asString().setCallback(new FutureCallback<String>() {

            public void onCompleted(Exception e, String result) {
                //pDialog.dismiss();
                if(result == null)

                    Log.d(TAG, "No response from the server!!!");
                else {
                    Log.i(TAG,"test");
                    System.out.println(result);
                    com.example.yann.classroom_community.BDD2.Friend friend;
                    List<com.example.yann.classroom_community.BDD2.Friend> friends;
                    friend = com.example.yann.classroom_community.BDD2.Friend.getFriendFromJson(result);
                    friends = com.example.yann.classroom_community.BDD2.Friend.getListOfFriendsFromJson(result);

                }
            }
        });
    }
}
