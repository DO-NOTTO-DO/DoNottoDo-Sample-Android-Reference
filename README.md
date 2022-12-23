# DoNottoDo_Sample_Android_Reference



## Visibility With Animation (낫투두 생성 뷰, 4번 기능 *상황을 추가해주세요)

<div>
<img src="https://github.com/DO-NOTTO-DO/DoNottoDo-Sample-Android-Reference/blob/master/art/slide_up_hide.gif" width="300" height="650"/>
<img src="https://github.com/DO-NOTTO-DO/DoNottoDo-Sample-Android-Reference/blob/master/art/slide_down_hide.gif" width="300" height="650"/>
</div>




## NestedRecyclerView (성취 뷰)

<div>
<img src="https://github.com/DO-NOTTO-DO/DoNottoDo-Sample-Android-Reference/blob/master/art/nested_recyclerview.gif" width="300" height="650"/>
</div>




## SwipeRefreshNestedScrollView (홈화면)

<div>
<img src="https://github.com/DO-NOTTO-DO/DoNottoDo-Sample-Android-Reference/blob/master/art/swipe_refresh_nested_scroll_view.gif" width="300" height="650"/>
</div>




## Selection RecyclerView

<div>
<img src="https://github.com/DO-NOTTO-DO/DoNottoDo-Sample-Android-Reference/blob/master/art/single_selection_1.gif" width="300" height="650"/>
<img src="https://github.com/DO-NOTTO-DO/DoNottoDo-Sample-Android-Reference/blob/master/art/multiple_selection_1.gif" width="300" height="650"/>
<img src="https://github.com/DO-NOTTO-DO/DoNottoDo-Sample-Android-Reference/blob/master/art/interface_selection_1.gif" width="300" height="650"/>
</div>




## CatchFragmentEvent, ChangeFragment

이 2개는 Widget이나 Component에 대한 구현체를 보여주는 것은 아닙니다.

앱잼을 진행하면서 Fragment라는 부분화면 객체를 많이 사용하게 될텐데, Fragment를 mvvm과 곁드려서 사용하다보면 놓치는 부분들이 존재하기 마련입니다.

지금은 많이 사용되지 않는 방법들이지만, 개발을 하다보면 기능 중에 가끔 필요한 경우들이 존재해서 적어놓았습니다.

코드를 읽기 싫은 분들을 위해 조금 요약하자면

> Fragment의 Creation(생성)단계를 나타내는 메서드로는 onCreate , onCreateView, onViewCreated 입니다.
>
> 각 메서드의 차이점은
>
> onCreate은 fragment instance를 생성하는 과정
>
> onCreateView는 fragment에 보여줄 View(xml , binding)을 생성하는 과정
>
> onViewCreated는 fragment의 instance, view가 전부 올바르게 생성되었다는 영역입니다.
>
> 그러므로 Observing을 진행하거나, view의 초기화를 할 때에는 onViewCreated에서 행하는 것이 올바른 방법입니다.
>
> 
> 이처럼 단계를 만든 이유는 Activity위의 화면이지만, 때때로 activity보다 먼저 생성되는 순간들이 존재하기에 보다 복잡하게 단계들을 나누어서 생성합니다.
