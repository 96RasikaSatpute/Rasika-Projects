package com.miniproject.bhojanamv3.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.miniproject.bhojanamv3.R;
import com.miniproject.bhojanamv3.adapter.ViewPagerFragmentAdapter;
import com.miniproject.bhojanamv3.data.ListData;
import com.miniproject.bhojanamv3.dialog.DialogProgress;
import com.miniproject.bhojanamv3.utils.Constants;
import com.miniproject.bhojanamv3.utils.HorizontalFlipTransformation;
import com.miniproject.bhojanamv3.utils.ToastHelper;
import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    ArrayList<ListData> data = new ArrayList<>();
    ArrayList<ListData> dataClosed = new ArrayList<>();
    ArrayList<ListData> dataOpen = new ArrayList<>();
    DialogProgress dialogProgress;
    ArrayList<Fragment> fragments = new ArrayList<>();
    SharedPreferences sharedPreferences;
    TabLayout tableLayout;
    /* access modifiers changed from: private */
    public String[] titles = {"COMPLETED", "OPEN"};
    ViewPager2 viewPager2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        this.tableLayout = (TabLayout) view.findViewById(R.id.tlActivity);
        this.viewPager2 = (ViewPager2) view.findViewById(R.id.vpActivity);
        this.sharedPreferences = getActivity().getSharedPreferences(Constants.MY_PREF, 0);
        this.viewPager2.setPageTransformer(new HorizontalFlipTransformation());
        DialogProgress dialogProgress2 = new DialogProgress("One Moment, Please");
        this.dialogProgress = dialogProgress2;
        dialogProgress2.setCancelable(false);
        this.dialogProgress.show(getActivity().getSupportFragmentManager(), "Dialog Progress");
        getData();
        return view;
    }

    private void getData() {
        final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.getReference("History/" + this.sharedPreferences.getString(Constants.USERNAME, "guest")).addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    HistoryFragment.this.dataClosed.add((ListData) dataSnapshot.getValue(ListData.class));
                }
                firebaseDatabase.getReference("ListOpen/" + HistoryFragment.this.sharedPreferences.getString(Constants.USERNAME, "guest")).addListenerForSingleValueEvent(new ValueEventListener() {
                    public void onDataChange(DataSnapshot snapshot) {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            HistoryFragment.this.dataOpen.add((ListData) dataSnapshot.getValue(ListData.class));
                        }
                        HistoryFragment.this.fragments.add(new HistoryDonationFragment(HistoryFragment.this.dataClosed));
                        HistoryFragment.this.fragments.add(new HistoryOpenFragment(HistoryFragment.this.dataOpen));
                        HistoryFragment.this.viewPager2.setAdapter(new ViewPagerFragmentAdapter(HistoryFragment.this.getActivity(), HistoryFragment.this.fragments));
                        new TabLayoutMediator(HistoryFragment.this.tableLayout, HistoryFragment.this.viewPager2, 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0080: INVOKE  
                              (wrap: com.google.android.material.tabs.TabLayoutMediator : 0x007d: CONSTRUCTOR  (r1v9 com.google.android.material.tabs.TabLayoutMediator) = 
                              (wrap: com.google.android.material.tabs.TabLayout : 0x0070: IGET  (r2v11 com.google.android.material.tabs.TabLayout) = 
                              (wrap: com.miniproject.bhojanamv3.fragment.HistoryFragment : 0x006e: IGET  (r2v10 com.miniproject.bhojanamv3.fragment.HistoryFragment) = 
                              (wrap: com.miniproject.bhojanamv3.fragment.HistoryFragment$1 : 0x006c: IGET  (r2v9 com.miniproject.bhojanamv3.fragment.HistoryFragment$1) = 
                              (r5v0 'this' com.miniproject.bhojanamv3.fragment.HistoryFragment$1$1 A[THIS])
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.1.1.this$1 com.miniproject.bhojanamv3.fragment.HistoryFragment$1)
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.1.this$0 com.miniproject.bhojanamv3.fragment.HistoryFragment)
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.tableLayout com.google.android.material.tabs.TabLayout)
                              (wrap: androidx.viewpager2.widget.ViewPager2 : 0x0076: IGET  (r3v2 androidx.viewpager2.widget.ViewPager2) = 
                              (wrap: com.miniproject.bhojanamv3.fragment.HistoryFragment : 0x0074: IGET  (r3v1 com.miniproject.bhojanamv3.fragment.HistoryFragment) = 
                              (wrap: com.miniproject.bhojanamv3.fragment.HistoryFragment$1 : 0x0072: IGET  (r3v0 com.miniproject.bhojanamv3.fragment.HistoryFragment$1) = 
                              (r5v0 'this' com.miniproject.bhojanamv3.fragment.HistoryFragment$1$1 A[THIS])
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.1.1.this$1 com.miniproject.bhojanamv3.fragment.HistoryFragment$1)
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.1.this$0 com.miniproject.bhojanamv3.fragment.HistoryFragment)
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.viewPager2 androidx.viewpager2.widget.ViewPager2)
                              (wrap: com.miniproject.bhojanamv3.fragment.-$$Lambda$HistoryFragment$1$1$JvIsyqgeLLqdeP1ajxX97P5vO1Q : 0x007a: CONSTRUCTOR  (r4v0 com.miniproject.bhojanamv3.fragment.-$$Lambda$HistoryFragment$1$1$JvIsyqgeLLqdeP1ajxX97P5vO1Q) = 
                              (r5v0 'this' com.miniproject.bhojanamv3.fragment.HistoryFragment$1$1 A[THIS])
                             call: com.miniproject.bhojanamv3.fragment.-$$Lambda$HistoryFragment$1$1$JvIsyqgeLLqdeP1ajxX97P5vO1Q.<init>(com.miniproject.bhojanamv3.fragment.HistoryFragment$1$1):void type: CONSTRUCTOR)
                             call: com.google.android.material.tabs.TabLayoutMediator.<init>(com.google.android.material.tabs.TabLayout, androidx.viewpager2.widget.ViewPager2, com.google.android.material.tabs.TabLayoutMediator$TabConfigurationStrategy):void type: CONSTRUCTOR)
                             com.google.android.material.tabs.TabLayoutMediator.attach():void type: VIRTUAL in method: com.miniproject.bhojanamv3.fragment.HistoryFragment.1.1.onDataChange(com.google.firebase.database.DataSnapshot):void, dex: classes2.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007d: CONSTRUCTOR  (r1v9 com.google.android.material.tabs.TabLayoutMediator) = 
                              (wrap: com.google.android.material.tabs.TabLayout : 0x0070: IGET  (r2v11 com.google.android.material.tabs.TabLayout) = 
                              (wrap: com.miniproject.bhojanamv3.fragment.HistoryFragment : 0x006e: IGET  (r2v10 com.miniproject.bhojanamv3.fragment.HistoryFragment) = 
                              (wrap: com.miniproject.bhojanamv3.fragment.HistoryFragment$1 : 0x006c: IGET  (r2v9 com.miniproject.bhojanamv3.fragment.HistoryFragment$1) = 
                              (r5v0 'this' com.miniproject.bhojanamv3.fragment.HistoryFragment$1$1 A[THIS])
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.1.1.this$1 com.miniproject.bhojanamv3.fragment.HistoryFragment$1)
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.1.this$0 com.miniproject.bhojanamv3.fragment.HistoryFragment)
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.tableLayout com.google.android.material.tabs.TabLayout)
                              (wrap: androidx.viewpager2.widget.ViewPager2 : 0x0076: IGET  (r3v2 androidx.viewpager2.widget.ViewPager2) = 
                              (wrap: com.miniproject.bhojanamv3.fragment.HistoryFragment : 0x0074: IGET  (r3v1 com.miniproject.bhojanamv3.fragment.HistoryFragment) = 
                              (wrap: com.miniproject.bhojanamv3.fragment.HistoryFragment$1 : 0x0072: IGET  (r3v0 com.miniproject.bhojanamv3.fragment.HistoryFragment$1) = 
                              (r5v0 'this' com.miniproject.bhojanamv3.fragment.HistoryFragment$1$1 A[THIS])
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.1.1.this$1 com.miniproject.bhojanamv3.fragment.HistoryFragment$1)
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.1.this$0 com.miniproject.bhojanamv3.fragment.HistoryFragment)
                             com.miniproject.bhojanamv3.fragment.HistoryFragment.viewPager2 androidx.viewpager2.widget.ViewPager2)
                              (wrap: com.miniproject.bhojanamv3.fragment.-$$Lambda$HistoryFragment$1$1$JvIsyqgeLLqdeP1ajxX97P5vO1Q : 0x007a: CONSTRUCTOR  (r4v0 com.miniproject.bhojanamv3.fragment.-$$Lambda$HistoryFragment$1$1$JvIsyqgeLLqdeP1ajxX97P5vO1Q) = 
                              (r5v0 'this' com.miniproject.bhojanamv3.fragment.HistoryFragment$1$1 A[THIS])
                             call: com.miniproject.bhojanamv3.fragment.-$$Lambda$HistoryFragment$1$1$JvIsyqgeLLqdeP1ajxX97P5vO1Q.<init>(com.miniproject.bhojanamv3.fragment.HistoryFragment$1$1):void type: CONSTRUCTOR)
                             call: com.google.android.material.tabs.TabLayoutMediator.<init>(com.google.android.material.tabs.TabLayout, androidx.viewpager2.widget.ViewPager2, com.google.android.material.tabs.TabLayoutMediator$TabConfigurationStrategy):void type: CONSTRUCTOR in method: com.miniproject.bhojanamv3.fragment.HistoryFragment.1.1.onDataChange(com.google.firebase.database.DataSnapshot):void, dex: classes2.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	... 93 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007a: CONSTRUCTOR  (r4v0 com.miniproject.bhojanamv3.fragment.-$$Lambda$HistoryFragment$1$1$JvIsyqgeLLqdeP1ajxX97P5vO1Q) = 
                              (r5v0 'this' com.miniproject.bhojanamv3.fragment.HistoryFragment$1$1 A[THIS])
                             call: com.miniproject.bhojanamv3.fragment.-$$Lambda$HistoryFragment$1$1$JvIsyqgeLLqdeP1ajxX97P5vO1Q.<init>(com.miniproject.bhojanamv3.fragment.HistoryFragment$1$1):void type: CONSTRUCTOR in method: com.miniproject.bhojanamv3.fragment.HistoryFragment.1.1.onDataChange(com.google.firebase.database.DataSnapshot):void, dex: classes2.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	... 99 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.miniproject.bhojanamv3.fragment.-$$Lambda$HistoryFragment$1$1$JvIsyqgeLLqdeP1ajxX97P5vO1Q, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	... 105 more
                            */
                        /*
                            this = this;
                            java.lang.Iterable r0 = r6.getChildren()
                            java.util.Iterator r0 = r0.iterator()
                        L_0x0008:
                            boolean r1 = r0.hasNext()
                            if (r1 == 0) goto L_0x0026
                            java.lang.Object r1 = r0.next()
                            com.google.firebase.database.DataSnapshot r1 = (com.google.firebase.database.DataSnapshot) r1
                            java.lang.Class<com.miniproject.bhojanamv3.data.ListData> r2 = com.miniproject.bhojanamv3.data.ListData.class
                            java.lang.Object r2 = r1.getValue(r2)
                            com.miniproject.bhojanamv3.data.ListData r2 = (com.miniproject.bhojanamv3.data.ListData) r2
                            com.miniproject.bhojanamv3.fragment.HistoryFragment$1 r3 = com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.this
                            com.miniproject.bhojanamv3.fragment.HistoryFragment r3 = com.miniproject.bhojanamv3.fragment.HistoryFragment.this
                            java.util.ArrayList<com.miniproject.bhojanamv3.data.ListData> r3 = r3.dataOpen
                            r3.add(r2)
                            goto L_0x0008
                        L_0x0026:
                            com.miniproject.bhojanamv3.fragment.HistoryFragment$1 r0 = com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.this
                            com.miniproject.bhojanamv3.fragment.HistoryFragment r0 = com.miniproject.bhojanamv3.fragment.HistoryFragment.this
                            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r0.fragments
                            com.miniproject.bhojanamv3.fragment.HistoryDonationFragment r1 = new com.miniproject.bhojanamv3.fragment.HistoryDonationFragment
                            com.miniproject.bhojanamv3.fragment.HistoryFragment$1 r2 = com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.this
                            com.miniproject.bhojanamv3.fragment.HistoryFragment r2 = com.miniproject.bhojanamv3.fragment.HistoryFragment.this
                            java.util.ArrayList<com.miniproject.bhojanamv3.data.ListData> r2 = r2.dataClosed
                            r1.<init>(r2)
                            r0.add(r1)
                            com.miniproject.bhojanamv3.fragment.HistoryFragment$1 r0 = com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.this
                            com.miniproject.bhojanamv3.fragment.HistoryFragment r0 = com.miniproject.bhojanamv3.fragment.HistoryFragment.this
                            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r0.fragments
                            com.miniproject.bhojanamv3.fragment.HistoryOpenFragment r1 = new com.miniproject.bhojanamv3.fragment.HistoryOpenFragment
                            com.miniproject.bhojanamv3.fragment.HistoryFragment$1 r2 = com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.this
                            com.miniproject.bhojanamv3.fragment.HistoryFragment r2 = com.miniproject.bhojanamv3.fragment.HistoryFragment.this
                            java.util.ArrayList<com.miniproject.bhojanamv3.data.ListData> r2 = r2.dataOpen
                            r1.<init>(r2)
                            r0.add(r1)
                            com.miniproject.bhojanamv3.adapter.ViewPagerFragmentAdapter r0 = new com.miniproject.bhojanamv3.adapter.ViewPagerFragmentAdapter
                            com.miniproject.bhojanamv3.fragment.HistoryFragment$1 r1 = com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.this
                            com.miniproject.bhojanamv3.fragment.HistoryFragment r1 = com.miniproject.bhojanamv3.fragment.HistoryFragment.this
                            androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                            com.miniproject.bhojanamv3.fragment.HistoryFragment$1 r2 = com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.this
                            com.miniproject.bhojanamv3.fragment.HistoryFragment r2 = com.miniproject.bhojanamv3.fragment.HistoryFragment.this
                            java.util.ArrayList<androidx.fragment.app.Fragment> r2 = r2.fragments
                            r0.<init>(r1, r2)
                            com.miniproject.bhojanamv3.fragment.HistoryFragment$1 r1 = com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.this
                            com.miniproject.bhojanamv3.fragment.HistoryFragment r1 = com.miniproject.bhojanamv3.fragment.HistoryFragment.this
                            androidx.viewpager2.widget.ViewPager2 r1 = r1.viewPager2
                            r1.setAdapter(r0)
                            com.google.android.material.tabs.TabLayoutMediator r1 = new com.google.android.material.tabs.TabLayoutMediator
                            com.miniproject.bhojanamv3.fragment.HistoryFragment$1 r2 = com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.this
                            com.miniproject.bhojanamv3.fragment.HistoryFragment r2 = com.miniproject.bhojanamv3.fragment.HistoryFragment.this
                            com.google.android.material.tabs.TabLayout r2 = r2.tableLayout
                            com.miniproject.bhojanamv3.fragment.HistoryFragment$1 r3 = com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.this
                            com.miniproject.bhojanamv3.fragment.HistoryFragment r3 = com.miniproject.bhojanamv3.fragment.HistoryFragment.this
                            androidx.viewpager2.widget.ViewPager2 r3 = r3.viewPager2
                            com.miniproject.bhojanamv3.fragment.-$$Lambda$HistoryFragment$1$1$JvIsyqgeLLqdeP1ajxX97P5vO1Q r4 = new com.miniproject.bhojanamv3.fragment.-$$Lambda$HistoryFragment$1$1$JvIsyqgeLLqdeP1ajxX97P5vO1Q
                            r4.<init>(r5)
                            r1.<init>(r2, r3, r4)
                            r1.attach()
                            com.miniproject.bhojanamv3.fragment.HistoryFragment$1 r1 = com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.this
                            com.miniproject.bhojanamv3.fragment.HistoryFragment r1 = com.miniproject.bhojanamv3.fragment.HistoryFragment.this
                            com.miniproject.bhojanamv3.dialog.DialogProgress r1 = r1.dialogProgress
                            r1.dismiss()
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.miniproject.bhojanamv3.fragment.HistoryFragment.AnonymousClass1.AnonymousClass1.onDataChange(com.google.firebase.database.DataSnapshot):void");
                    }

                    public /* synthetic */ void lambda$onDataChange$0$HistoryFragment$1$1(TabLayout.Tab tab, int position) {
                        tab.setText((CharSequence) HistoryFragment.this.titles[position]);
                    }

                    public void onCancelled(DatabaseError error) {
                        HistoryFragment.this.dialogProgress.dismiss();
                        new ToastHelper().makeToast(HistoryFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
                    }
                });
            }

            public void onCancelled(DatabaseError error) {
                HistoryFragment.this.dialogProgress.dismiss();
                new ToastHelper().makeToast(HistoryFragment.this.getActivity(), "Something went wrong! Please try again later.", 1);
            }
        });
    }
}
